fun main() {
    var t = i()
    val sb = StringBuilder()
    var n: Int
    val a = IntArray(501)
    val d = Array(501) { IntArray(501) }
    val s = IntArray(501)
    var j: Int
    var c: Int
    var rs: Int
    while (t-- > 0) {
        n = i()
        for (i in 1..n) {
            a[i] = i()
            s[i] = s[i - 1] + a[i]
        }
        for (i in 1 until n) {
            d[i][i + 1] = a[i] + a[i + 1]
        }
        for (g in 2 until n) {
            for (i in 1..n - g) {
                j = i + g
                d[i][j] = Integer.MAX_VALUE
                rs = s[j] - s[i - 1]
                for (k in i until j) {
                    c = d[i][k] + d[k + 1][j] + rs
                    if (d[i][j] > c) d[i][j] = c
                }
            }
        }
        sb.append(d[1][n]).append('\n')
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