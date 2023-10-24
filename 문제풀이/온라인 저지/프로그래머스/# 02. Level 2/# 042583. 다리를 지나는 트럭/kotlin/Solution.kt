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
