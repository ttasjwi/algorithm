fun main() {
    val n = i()
    val line = IntArray(501)
    val a = IntArray(n)
    val dp = IntArray(n)

    for (i in 1..n) {
        line[i()] = i()
    }
    var tmp = 0
    for (i in 1..500) {
        if (line[i] > 0) a[tmp++] = line[i]
        if (tmp == n) break
    }

    tmp = 0
    for (i in a.indices) {
        dp[i] = 1
        for (j in 0..i - 1) {
            if (a[j] < a[i]) {
                dp[i] = maxOf(dp[j] + 1, dp[i])
            }
        }
        tmp = maxOf(tmp, dp[i])
    }
    print(n - tmp)
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
