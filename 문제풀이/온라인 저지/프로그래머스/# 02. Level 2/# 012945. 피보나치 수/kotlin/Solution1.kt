class Solution1 {
    fun solution(n: Int): Int {
        var p1 = 0
        var p2 = 1
        val div = 1_234_567
        for (i in 2..n) {
            p2 = ((p1 + p2)%div).also { p1 = p2 }
        }
        return p2
    }
}