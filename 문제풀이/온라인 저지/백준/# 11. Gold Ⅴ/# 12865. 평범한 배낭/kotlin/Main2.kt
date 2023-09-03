fun main() {
    val n = i()
    val k = i()
    val dp = IntArray(k + 1)
    var w: Int
    var v: Int
    for (i in 1..n) {
        w = i()
        v = i()
        for (j in k downTo w) {
            if (dp[j] < dp[j-w] + v) dp[j] = dp[j-w] + v
        }
    }
    print(dp[k])
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