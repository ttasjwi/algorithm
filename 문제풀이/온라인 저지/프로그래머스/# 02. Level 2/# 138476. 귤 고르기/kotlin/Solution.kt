import java.util.*

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (t in tangerine) {
            if (!map.containsKey(t)) {
                map[t] = 1
            } else {
                map[t] = map[t]!! + 1
            }
        }
        val arr = map.values.toIntArray()
        Arrays.sort(arr)
        var count = 0
        var cur = k
        for (i in arr.lastIndex downTo 0) {
            count ++
            cur -= arr[i]
            if (cur <= 0) break
        }
        return count
    }
}
