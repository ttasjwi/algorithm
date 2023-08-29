fun main() {
    val n = i()
    val sums = IntArray(n+1)
    var input: Int
    for (i in 1..n) {
        input = i()
        sums[i] = sums[i-1] + input
    }
    var max = -1001
    for (lt in 1..n) {
        for (rt in lt..n) {
            max = (sums[rt] - sums[lt-1]).coerceAtLeast(max)
        }
    }
    print(max)
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