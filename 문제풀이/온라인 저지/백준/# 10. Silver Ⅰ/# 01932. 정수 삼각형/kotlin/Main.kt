fun main() {
    val n = i()
    val dp = Array(n+1) { IntArray(it + 2)}
    var answer = 0
    for (r in 1..n) {
        for (c in 1..r) {
            dp[r][c] = i() + Math.max(dp[r-1][c-1], dp[r-1][c])
            if (r == n) {
                answer = Math.max(dp[r][c], answer)
            }
        }
    }
    print(answer)
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