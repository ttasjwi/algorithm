fun main() {
    val n = i()
    var m = i()
    val dp = Array(n+1){IntArray(n+1)}
    for (x in 1..n) {
        for (y in 1..n) {
            dp[x][y] = dp[x-1][y] + dp[x][y-1] - dp[x-1][y-1] + i()
        }
    }
    val sb = StringBuilder()
    var x1: Int
    var y1: Int
    var x2: Int
    var y2: Int
    while (m -- >0) {
        x1 = i()
        y1 = i()
        x2 = i()
        y2 = i()
        sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]).append('\n')
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