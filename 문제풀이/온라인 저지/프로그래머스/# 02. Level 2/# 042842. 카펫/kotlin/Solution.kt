import kotlin.math.sqrt

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val s = brown + yellow

        var a: Int
        var answer: IntArray? = null
        for (b in 3..sqrt(s.toDouble()).toInt()) {
            if (s%b ==0) {
                a = s/b
                if ((a-2) * (b-2) == yellow) {
                    answer = intArrayOf(a,b)
                    break
                }
            }
        }
        return answer!!
    }
}
