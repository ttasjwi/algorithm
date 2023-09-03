fun main() {
    val n = i()
    var m = i()
    val dp = IntArray(n+1)
    for (i in 1..n) dp[i] = dp[i-1] + i()
    val sb = StringBuilder()
    while (m-- > 0) {
        sb.append(-dp[i()-1] + dp[i()]).append('\n')
    }
    print(sb)
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