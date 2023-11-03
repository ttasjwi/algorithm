# 문제
- 플랫폼 : 프로그래머스
- 번호 : 142085
- 제목 : 디펜스 게임
- 난이도 : Level 2
- 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다. 준호가 몇 라운드까지 막을 수 있는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/142085" target="_blank">링크</a>

---

# 필요 지식
- 우선순위 큐

---

# 풀이
```kotlin
class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var life = n
        var chance = k
        val heap = Heap(enemy.size)
        for (i in enemy.indices) {
            life -= enemy[i]
            heap.add(enemy[i])
            if (life < 0) {
                if (chance > 0 && heap.isNotEmpty()) {
                    life += heap.poll()
                    chance --
                } else {
                    return i
                }
            }
        }
        return enemy.size
    }
}

class Heap(cap: Int) {

    private val arr = IntArray(cap + 1)

    private var size = 0

    fun add(e: Int) {
        arr[++size] = e
        var i = size
        var p = size shr 1
        var big = i
        while (p > 0) {
            if (arr[i] > arr[p]) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun poll() : Int {
        val e = arr[1]
        arr[1] = arr[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while(true) {
            if (lt <= size && arr[lt] > arr[big]) big = lt
            if (rt <= size && arr[rt] > arr[big]) big = rt
            if (i == big) break
            arr[i] = arr[big].also{arr[big] = arr[i]}
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0

}
```
- 생명력 : life
- 무적권 갯수 : chance
- 최대힙 : Heap
- 매 라운드마다 생명력을 적의 갯수만큼 차감하고 힙에 그 갯수를 삽입한다.
- 목숨이 0보다 작아졌다면, chance가 0보다 크고 힙이 비어있지 않다면 힙에서 값을 꺼내서 그 값만큼 생명력에 더한다.
  (목숨이 0보다 작거나 같아졌다면, 방금 차감된 값보다 크거나 같은 값을 반드시 꺼낼 수 있다.)
- chance 가 0보다 작거나 같다면 더 이상 무적권을 쓸 수 없으므로 그대로 i를 반환한다.
- 끝까지 순회하면 enemy의 size를 반환한다.

---
