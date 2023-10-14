class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left).toInt() + 1)
        var r: Int
        var c: Int
        for (i in left..right) {
            r = (i / n).toInt()
            c = (i % n).toInt()
            answer[(i - left).toInt()] = if (r >= c) r + 1 else c + 1
        }
        return answer
    }

}
