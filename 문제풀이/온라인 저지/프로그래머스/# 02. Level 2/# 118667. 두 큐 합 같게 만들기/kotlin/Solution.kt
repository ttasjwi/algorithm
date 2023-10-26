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
