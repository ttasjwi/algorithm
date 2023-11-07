class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val map = HashMap<String, Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }
        val result = IntArray(photo.size)
        for (i in photo.indices) {
            for (e in photo[i]) {
                if (map.containsKey(e)) {
                    result[i] += map[e]!!
                }
            }
        }
        return result
    }
}