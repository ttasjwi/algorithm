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
