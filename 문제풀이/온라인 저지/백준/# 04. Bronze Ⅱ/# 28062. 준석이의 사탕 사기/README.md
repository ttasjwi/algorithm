# 문제
- 플랫폼 : 백준
- 번호 : 28062
- 제목 : 준석이의 사탕 사기
- 난이도 : Bronze 2
- 준석이가 최대로 가져갈 수 있는 사탕의 개수를 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/28062" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 우선순위 큐

---

# 풀이
```kotlin
fun main() {
    val n = i()

    var answer = 0
    var cur: Int
    val heap = MaxHeap(n)
    repeat(n) {
        cur = i()
        if (cur %2 == 0) answer += cur
        else heap.enQueue(cur)
    }

    while(heap.size >=2) {
        answer += (heap.deQueue() + heap.deQueue())
    }
    writeInt(answer)
    flushBuffer()
}
```
- 짝수는 모두 더한다.
- 홀수는 우선순위큐(최대힙)에 삽입한다.
- 큐의 원소 갯수가 2개 이상이면, 2개씩 추출하여 합한다.

---
