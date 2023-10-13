class Solution {
    fun solution(elements: IntArray): Int {
        var rt: Int
        var sum: Int
        val set = HashSet<Int>()
        val size = elements.size
        for (lt in 0 until size) {
            sum = 0
            rt = lt
            do {
                sum += elements[rt]
                set += sum
                rt = (rt + 1 + size)%size
            } while (rt != lt)
        }
        return set.size
    }
}
