fun main() {
    val p = LongArray(101)
    p[1] = 1
    p[2] = 1
    p[3] = 1
    p[4] = 2
    p[5] = 2

    for (i in 6..100) {
        p[i] = p [i-5] + p[i-1]
    }
    var t = i()
    val sb = StringBuilder()
    while (t-- > 0) {
        sb.append(p[i()]).append('\n')
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