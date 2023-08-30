fun main() {
    val n = i()
    val c = IntArray(n + 1)
    val dp = IntArray(n + 1)
    for (i in 1..n) {
        c[i] = i()
        dp[i] = when (i) {
            1 -> c[i]
            2 -> c[i - 1] + c[i]
            else -> c[i] + Math.max(dp[i - 3] + c[i - 1], dp[i - 2])
        }
    }
    print(dp[n])
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
