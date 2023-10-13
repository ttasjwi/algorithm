class Solution {
    fun solution(n: Int): Long {
        if (n == 1) return 1
        var before = 1L
        var cur = 2L
        for (i in 3..n) {
            cur = (before + cur).also { before = cur }
            cur %= 1234567L
        }
        return cur
    }
}
