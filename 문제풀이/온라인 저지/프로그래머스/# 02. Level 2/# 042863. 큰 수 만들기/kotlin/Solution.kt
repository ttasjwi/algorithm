class Solution {
    fun solution(number: String, k: Int): String {
        var k = k
        val dq = Deque(number.length)
        for (n in number) {
            while (dq.isNotEmpty() && dq.last() < n && k > 0) {
                dq.dqLast()
                k--
            }
            dq.eq(n)
        }
        while (k > 0) {
            dq.dqLast()
            k--
        }
        val sb = StringBuilder()
        while (dq.isNotEmpty()) {
            sb.append(dq.dqFirst())
        }
        return sb.toString()
    }
}

class Deque(cap: Int) {
    private val c = cap + 1
    private val arr = CharArray(c)
    private var front = 0
    private var rear = 0

    fun eq(e: Char) {
        arr[((rear + 1 + c) % c).also { rear = it }] = e
    }

    fun dqFirst(): Char = arr[((front + 1 + c) % c).also { front = it }]
    fun dqLast(): Char = arr[rear.also { rear = (it - 1 + c) % c }]
    fun last(): Char = arr[rear]
    fun isNotEmpty(): Boolean = front != rear
}
