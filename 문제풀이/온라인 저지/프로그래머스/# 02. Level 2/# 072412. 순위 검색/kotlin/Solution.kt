class Solution {

    private val map = HashMap<String, MutableList<Int>>()
    private val items = Array(4) { "" }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        for (i in info.indices) dfs(info[i].split(' '), 0)
        for (list in map.values) list.sort()

        var q: List<String>
        var key: String
        var score: Int
        val answer = IntArray(query.size)
        for (i in query.indices) {
            q = query[i].split(' ')
            key = makeKey(q)
            score = q[7].toInt()
            answer[i] = if (!map.containsKey(key)) 0 else countGoe(map[key]!!, score)
        }
        return answer
    }

    private fun dfs(source: List<String>, idx: Int) {
        if (idx == 4) {
            val key = makeKeyFromItems()
            if (!map.containsKey(key)) map[key] = ArrayList()
            map[key]!! += source[4].toInt()
            return
        }
        items[idx] = "-"
        dfs(source, idx + 1)
        items[idx] = source[idx]
        dfs(source, idx + 1)
    }

    private fun makeKeyFromItems() = StringBuilder().append(items[0]).append(items[1]).append(items[2]).append(items[3]).toString()
    private fun makeKey(q: List<String>) = StringBuilder().append(q[0]).append(q[2]).append(q[4]).append(q[6]).toString()

    private fun countGoe(list: List<Int>, min: Int): Int {
        var lt = 0
        var rt = list.lastIndex
        var mid: Int
        var minIdx = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (list[mid] >= min) {
                minIdx = mid
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        return if (minIdx >= 0) list.size - minIdx else 0
    }
}
