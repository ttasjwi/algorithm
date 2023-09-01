fun main() {
    val n = i()
    val a = IntArray(n)
    val d = IntArray(n)
    for (i in a.indices) {
        a[i] = i()
    }
    var max = 0
    for (i in a.indices) {
        d[i] = 1
        for (j in 0..i - 1) {
            if (a[i] > a[j]) {
                d[i] = Math.max(d[i], d[j] + 1)
            }
        }
        if (max < d[i]) {
            max = d[i]
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
