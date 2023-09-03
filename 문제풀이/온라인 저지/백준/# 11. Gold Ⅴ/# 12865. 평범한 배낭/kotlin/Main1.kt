fun main() {
    val n = i()
    val k = i()
    val dp = Array(n + 1) { IntArray(k + 1) }
    var w: Int
    var v: Int
    for (i in 1..n) {
        w = i()
        v = i()
        for (j in 1..k) {
            dp[i][j] =
                if (w > j) dp[i - 1][j]
                else Math.max(v + dp[i - 1][j - w], dp[i - 1][j])
        }
    }
    print(dp[n][k])
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}