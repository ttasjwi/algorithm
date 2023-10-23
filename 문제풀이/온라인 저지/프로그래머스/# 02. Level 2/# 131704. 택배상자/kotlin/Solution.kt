class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0
        val sub = Stack(order.size)
        var box = 1
        for (curOrder in order) {
            if (box <= curOrder) {
                while (box < curOrder) sub.push(box++)
                answer++
                box++
                continue
            }
            if (sub.isNotEmpty() && sub.pop() == curOrder) {
                answer++
            } else {
                break
            }
        }
        return answer
    }
}

class Stack(cap: Int) {
    private val arr = IntArray(cap)
    private var size = 0
    fun push(e: Int) {
        arr[size++] = e
    }

    fun pop(): Int = arr[--size]
    fun isNotEmpty(): Boolean = size != 0
}
