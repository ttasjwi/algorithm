fun main() {
    val n = i()
    val k = i()
    val dp = IntArray(n+1)
    for (i in 1..n) dp[i] = dp[i-1] + i()
    var answer = -10_000_000
    for (i in n downTo k) {
        answer = Math.max(answer, dp[i] - dp[i-k])
    }
    print(answer)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    val n = c.toInt() == 45
    c = if (n) r() else c
    do { v = v * 10 + c - 48 } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}