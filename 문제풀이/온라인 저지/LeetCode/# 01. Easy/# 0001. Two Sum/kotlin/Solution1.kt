class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        var pair: Int
        for (i in nums.indices) {
            pair = target - nums[i]
            if (map.containsKey(pair)) {
                return intArrayOf(map[pair]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}
