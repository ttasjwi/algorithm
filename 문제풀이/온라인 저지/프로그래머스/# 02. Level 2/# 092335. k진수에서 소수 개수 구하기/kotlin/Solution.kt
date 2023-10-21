import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        val s = n.toString(k)
        var answer = 0
        var v = 0L
        for (i in 0.. s.length) {
            if (i == s.length || s[i] == '0') {
                if (v > 0) {
                    if (isPrime(v)) answer ++
                    v = 0
                }
            } else {
                v = v * 10 + s[i].code - 48
            }
        }
        return answer
    }
}

private fun isPrime(num: Long):Boolean {
    if (num == 1L) {
        return false
    }
    for (i in 2L..sqrt(num.toDouble()).toLong()) {
        if (num%i == 0L) {
            return false
        }
    }
    return true
}
