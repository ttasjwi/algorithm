# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042587
- 제목 : 프로세스
- 난이도 : Level 2
- 지정한 순서에 위치한 프로세스가 몇 번째로 실행되는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42587" target="_blank">링크</a>

---

# 필요 지식
- 우선순위 큐
- 큐

---

# 풀이
```kotlin
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val heap = Heap(priorities.size)
        for (i in priorities.indices) {
            heap.enQueue(priorities[i])
        }

        var cursor = 0
        var answer = 0
        while (heap.isNotEmpty()) {
            while (priorities[cursor] != heap.peek()) {
                cursor = (cursor + 1 + priorities.size) % priorities.size
            }
            heap.deQueue()
            answer++
            if (cursor == location) break
            priorities[cursor] = -1
        }
        return answer
    }
}

class Heap(cap: Int) {
    private var size = 0
    private val arr = IntArray(cap + 1)


    fun enQueue(e: Int) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i] > arr[p]) {
                arr[p] = arr[i].also{ arr[i] = arr[p]}
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun deQueue(): Int {
        val e = arr[1]
        arr[1] = arr[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while (true) {
            if (lt <= size && arr[lt] > arr[big]) big = lt
            if (rt <= size && arr[rt] > arr[big]) big = rt
            if (i == big) break
            arr[big] = arr[i].also{ arr[i] = arr[big]}
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun peek() = arr[1]

    fun isNotEmpty() = size != 0

}
```
- 배열의 각 작업 우선순위들을 순서대로 우선순위 큐에 삽입(최대 힙)
- 배열의 0번 인덱스에 cursor를 둔다.
- 우선순위 큐가 빌 때까지 다음을 반복한다.
  - cursor가 가리키는 작업 우선순위가 우선순위 큐 상에서 최상위일 때까지 cursor를 전진시킨다.(이때 인덱스가 최대 인덱스이면 다시 0번 인덱스로 돌아오도록 순환한다.)
  - 우선순위 큐에서 최상단 요소를 꺼낸다.(deQueue)
  - answer를 증가
  - 커서가 location과 같으면 반복문 탈출
  - 현재 작업을 완료됐다는 표시를 하기 위해 커서가 가리키는 작업의 우선순위를 -1로 표시한다.(이미 처리 됨)
- answer 출력
---
