class Solution {
    fun solution(numbers: IntArray): String {
        val sb = StringBuilder()
        val heap = Heap(numbers.size)
        for (number in numbers) {
            heap.enQueue(MyNumber(number))
        }
        while (heap.isNotEmpty()) {
            sb.append(heap.deQueue())
        }
        return if (sb[0] == '0') "0" else sb.toString()
    }

}

class Heap(cap: Int) {
    private val arr = arrayOfNulls<MyNumber>(cap + 1)
    private var size = 0

    fun enQueue(e: MyNumber) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i]!! > arr[p]!!) {
                arr[i] = arr[p].also{ arr[p] = arr[i] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun deQueue(): MyNumber {
        val e = arr[1]!!
        arr[1] = arr[size]
        arr[size--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while (true) {
            if (lt <=size && arr[lt]!! > arr[big]!!) big = lt
            if (rt <=size && arr[rt]!! > arr[big]!!) big = rt
            if (i == big) break
            arr[big] = arr[i].also{arr[i] = arr[big]}
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}

class MyNumber(private val num: Int): Comparable<MyNumber> {

    private val str = num.toString()
    private val length = str.length
    override fun toString(): String = str

    override fun compareTo(other: MyNumber): Int {
        var a = num
        repeat(other.length) {a *= 10}
        a += other.num
        var b = other.num
        repeat(length) {b *= 10}
        b += num
        return if (a>b) 1 else if (a<b) -1 else 0
    }

}
