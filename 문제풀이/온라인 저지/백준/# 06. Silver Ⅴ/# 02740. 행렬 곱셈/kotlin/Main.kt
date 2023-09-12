fun main() {
    val n = i()
    val m = i()
    val a = Array(n){IntArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            a[i][j] = i()
        }
    }
    i()
    val k = i()
    val b = Array(m){IntArray(k)}
    for (i in 0 until m) {
        for (j in 0 until k) {
            b[i][j] = i()
        }
    }
    val sb = StringBuilder()
    var tmp: Int
    for (t in 0 until n) {
        for (u in 0 until k) {
            tmp = 0
            for (v in 0 until m) {
                tmp += a[t][v] * b[v][u]
            }
            sb.append(tmp).append(' ')
        }
        sb.append('\n')
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