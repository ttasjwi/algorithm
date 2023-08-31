fun main() {
    val n = i()
    val dp = IntArray(n+1)
    fun dp(n: Int): Int {
        return when {
            n == 1 || dp[n] > 0 -> dp[n]
            n == 2 || n == 3 -> {dp[n] = 1; dp[n]}
            n % 6 == 0 -> {dp[n] = minOf(dp(n/3) , dp(n/2), dp(n-1)) + 1; dp[n]}
            n % 3 == 0 -> {dp[n] = minOf(dp(n/3), dp(n-1)) +1; dp[n]}
            n % 2 == 0 -> {dp[n] = minOf(dp(n/2), dp(n-1)) + 1; dp[n]}
            else -> {dp[n] = dp(n-1) + 1; dp[n]}
        }
    }
    print(dp(n))
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
