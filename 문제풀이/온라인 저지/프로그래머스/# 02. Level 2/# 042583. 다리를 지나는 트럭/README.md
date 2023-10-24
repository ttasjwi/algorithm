# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042583
- 제목 : 다리를 지나는 트럭
- 난이도 : Level 2
- 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42583" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
```kotlin
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val bridge = Bridge(bridge_length, weight)

        for (truck in truck_weights) {
            while (!bridge.dequeueAndEnqueue(truck));
        }
        while (!bridge.isEmpty()) bridge.dequeueAndEnqueueNothing()
        return bridge.elapsedTimeFromSetUp
    }
}

class Bridge(
    cap: Int,
    private val maxWeight: Int,
) {

    var elapsedTimeFromSetUp = 0
    private var c = cap + 1
    private val arr = IntArray(c + 1)
    private var front = 0
    private var rear = cap
    private var weight = 0

    /**
     * 다리에서, 제일 앞에 있던 요소를 다리 밖으로 빼고, 새로운 요소를 다리에 삽입 시도합니다.
     * 다리에 삽입하는 것에 성공하면 true를 반환합니다.
     * 다리에 삽입하는 것에 실패하면 false를 반환합니다.
     * 이 과정에서 시간이 경과합니다.
     */
    fun dequeueAndEnqueue(car: Int): Boolean {
        elapsedTimeFromSetUp ++

        if (weight - arr[(front + 1 + c) % c] + car <= maxWeight) {
            dequeue()
            enqueue(car)
            return true
        } else {
            dequeue()
            enqueue(0)
            return false
        }
    }

    /**
     * 다리에서 제일 앞의 요소를 다리 밖으로 빼고 아무 것도 통과시키지 않습니다.
     * 이 과정에서 시간이 경과합니다.
     */
    fun dequeueAndEnqueueNothing() {
        dequeueAndEnqueue(0)
    }

    /**
     * 다리에 아무 트럭도 없으면 true를 반환합니다.
     */
    fun isEmpty() = weight == 0

    private fun enqueue(e: Int) {
        arr[((rear + 1 + c) % c).also { rear = it }] = e
        weight += e
    }

    private fun dequeue(): Int = arr[((front + 1 + c) % c).also { front = it; weight -= arr[front] }]
}
```
- Bridge
  - 내부적으로 길이, 최대 중량에 대한 정보를 가지고 있다.
  - 매 초마다 트럭을 진입시키거나 아무 것도 진입시키지 않는 것을 시도할 수 있다.
    - 시간이 1초 경과하면 다리의 맨 앞 요소만 빠져나가고, 새로 트럭을 진입시키는 것을 시도한다.
    - 이 때 다리의 최대 중량보다 무겁지 않으면 진입에 성공하고, 중량보다 무겁지 않으면 공기(0)만 통과한다.
- truck_weights의 truck들을 계속 진입 시도를 시킨다.
- 모든 트럭을 진입시키는데 성공했다면 다리가 빌 때까지 시간을 기다린다.
- 최종적인 경과시간을 출력한다.

---
