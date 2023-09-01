fun main() {
    val n = i()
    val a = IntArray(n)
    val b = IntArray(n)
    val c = IntArray(n)
    for (i in a.indices) {
        a[i] = i()
    }
    for (i in a.indices) {
        b[i] = 1
        for (j in 0..i-1) {
            if (a[j] < a[i]) {
                b[i] = maxOf(b[i], b[j] + 1)
            }
        }
    }
    for (i in a.lastIndex downTo 0) {
        c[i] = 1
        for (j in a.lastIndex downTo i+1) {
            if (a[j] < a[i]) {
                c[i] = maxOf(c[i], c[j] + 1)
            }
        }
    }
    var answer = 0
    for (i in 0..n-1) {
        answer = maxOf(answer, b[i] + c[i] - 1)
    }
    print(answer)
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