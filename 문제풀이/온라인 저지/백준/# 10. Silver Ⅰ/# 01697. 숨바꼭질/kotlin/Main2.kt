fun main() {
    val n = i()
    val m = i()
    if (n >= m) {
        print(n - m)
        return
    }
    val dp = IntArray(2*m+1)
    for (i in dp.indices) {
        dp[i] = -1
    }

    /**
     * n에서 m까지 가는데 필요한 시간
     */
    fun dp(m:Int) : Int {
        when {
            dp[m] >= 0 -> return dp[m]
            n >= m -> {
                // m이 n보다 작거나 같으면 역방향 이동하므로 두 위치 차만큼 이동해야함
                dp[m] = n-m
                return dp[m]
            }
            // n < m

            // m == 1일 때
            m == 1 -> {
                dp[m] = 1
                return dp[m]
            }

            // m이 짝수 : 텔레포트 해오기 vs 앞에서 걸어오기
            m%2 == 0 -> {
                dp[m] = Math.min(m-n , dp(m/2) + 1)
                return dp[m]
            }
            // m이 홀수 : 앞에서 걸어오기 vs 뒤에서 걸어오기
            else -> {
                dp[m] = Math.min(dp(m-1), dp(m+1)) + 1
                return dp[m]
            }
        }
    }
    print(dp(m))
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s(): String {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
