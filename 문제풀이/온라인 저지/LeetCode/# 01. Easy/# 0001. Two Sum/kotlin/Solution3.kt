class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val items = nums.mapIndexed{idx, value -> Data(idx, value)}.sorted()
        var lt = 0
        var rt = items.lastIndex
        var sum: Int
        while (lt < rt) {
            sum = items[lt].value + items[rt].value
            if (sum == target) {
                return if (items[lt].idx < items[rt].idx) intArrayOf(items[lt].idx , items[rt].idx)
                else intArrayOf(items[rt].idx, items[lt].idx)
            } else if (sum > target) {
                rt --
            } else {
                lt ++
            }
        }
        return intArrayOf()
    }
}

class Data(val idx: Int, val value: Int) : Comparable<Data> {
    override fun compareTo(other: Data): Int {
        return value - other.value
    }
}
