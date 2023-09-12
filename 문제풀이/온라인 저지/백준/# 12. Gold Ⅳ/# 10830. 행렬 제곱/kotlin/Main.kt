fun main() {
    val c = 1000
    val n = i()
    val b = l()
    val a = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            a[i][j] = i() % c
        }
    }
    fun multiply(x: Array<IntArray>, y: Array<IntArray>): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    result[i][j] += x[i][k] * y[k][j]
                    result[i][j] %= c
                }
            }
        }
        return result
    }

    fun pow(arr: Array<IntArray>, x: Long): Array<IntArray> {
        if (x == 1L) return arr
        if (x == 2L) return multiply(arr, arr)
        return if (x % 2 == 0L)
            pow(pow(arr, x / 2), 2)
        else
            multiply(pow(pow(arr, x / 2), 2), arr)
    }

    val result = pow(a, b)
    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            sb.append(result[i][j]).append(' ')
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
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun l(): Long {
    var v = 0L
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
