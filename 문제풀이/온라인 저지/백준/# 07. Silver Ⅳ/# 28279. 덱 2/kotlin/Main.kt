fun main() {
    val sb = StringBuilder()
    var n = i()
    val c = n+1
    var f = 0
    var r = 0
    var s = 0
    val d = IntArray(c)
    var tmp: Int
    while(n-- > 0) {
       sb.append(when(i()) {
           1 -> {s++; d[f] = i(); f = (f-1+c)%c; continue}
           2 -> {s++; r = (r+1+c)%c;  d[r] = i(); continue}
           3 -> if (s == 0) -1 else {s--; f = (f+1+c)%c; d[f]}
           4 -> if (s == 0) -1 else {s--; tmp = d[r]; r = (r-1+c)%c; tmp}
           5 -> s
           6 -> if (s == 0) 1 else 0
           7 -> if (s == 0) -1 else d[(f+1+c)%c]
           else -> if (s == 0) -1 else d[r]
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

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}