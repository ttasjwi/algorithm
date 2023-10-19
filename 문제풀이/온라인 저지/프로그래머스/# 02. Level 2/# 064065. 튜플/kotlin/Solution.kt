class Solution {

    fun solution(s: String): IntArray {
        val items = ArrayList<ArrayList<Int>>()

        var idx = -1
        var v = 0
        for (i in 1..s.length - 2) {
            if (s[i] in '0'..'9') {
                v = v * 10 + s[i].toInt() - 48
            } else {
                if (s[i] == '{') {
                    idx++
                    items.add(ArrayList())
                } else if ((s[i] == ',' || s[i] == '}') && v != 0) {
                    items[idx].add(v)
                    v = 0
                }
            }
        }
        items.sortBy { it.size }

        val set = LinkedHashSet<Int>()
        for (arr in items) {
            for (e in arr) {
                set += e
            }
        }
        return set.toIntArray()
    }

}
