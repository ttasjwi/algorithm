class Solution1 {
    fun solution(s: String): String {
        var v: Int
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE
        for (x in s.split(' ')) {
            v = x.toInt()
            if (min > v) min = v
            if (max < v) max = v
        }
        return "$min $max"
    }
}