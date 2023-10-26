# 문제
- 플랫폼 : 프로그래머스
- 번호 : 118667
- 제목 : 두 큐 합 같게 만들기
- 난이도 : Level 2
- 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/118667" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
```kotlin
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val size = queue1.size
        val q1 = Queue(2*size)
        val q2 = Queue(2*size)
        for (e in queue1) q1.eq(e)
        for (e in queue2) q2.eq(e)
        val twoQueue = TwoQueue(q1, q2)
        if (twoQueue.hasSameSum()) return 0
        for (answer in 1..3*size) {
            twoQueue.bigToSmall()
            if (twoQueue.hasSameSum()) return answer
        }
        return - 1
    }
}

class Queue(cap: Int) {

    private val c = cap + 1
    private val arr = IntArray(c)
    private var front = 0
    private var rear = 0

    var sum = 0L
        private set

    fun eq(e: Int) {
        arr[((rear + 1 + c) % c).also { rear = it }] = e
        sum += e
    }

    fun dq(): Int {
        return arr[((front + 1 + c) % c).also { sum -= arr[it]; front = it }]
    }
}

class TwoQueue(
    private val q1: Queue,
    private val q2: Queue,
) {

    fun hasSameSum() : Boolean = q1.sum == q2.sum

    fun bigToSmall() {
        if (q1.sum > q2.sum) q2.eq(q1.dq())
        else if (q1.sum < q2.sum) q1.eq(q2.dq())
    }

}
```
- 큐 두개를 만들고 큐 각각이 sum 을 가지고 있게 한다.
- 합이 큰 큐에서 작은 큐로 옮기는 것을 반복한다.
- 이 반복 횟수가 3 * size 만큼을 넘어서면 -1을 반환하게 한다.

---
