fun main() {
    var n = i()
    val q = IntArray(n+1)
    var f = 0
    var r = 0
    var s = 0
    val sb = StringBuilder()
    while (n-- > 0) {
        sb.append(when (c()) {
            'o' -> if (s==0) -1 else {s--; q[(f++)+1]}
            'i' -> s
            'm' -> if (s==0) 1 else 0
            'r' -> if (s==0) -1 else q[f+1]
            'a' -> if (s==0) -1 else q[r]
            else -> {s++; q[++r] = i(); continue}
        }).append('\n')
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

private fun c(): Char {
    r()
    val c = r()
    while (r() > 96);
    return c.toChar()
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
