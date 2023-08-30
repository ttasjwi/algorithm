fun main() {
    var n = i()
    var r = i()
    var g = i()
    var b = i()
    var br: Int
    var bg: Int
    var bb: Int

    while (n-- > 1) {
        br = r
        bg = g
        bb = b
        r = i() + if (bg < bb) bg else bb
        g = i() + if (br < bb) br else bb
        b = i() + if (br < bg) br else bg
    }
    print(minOf(r,g,b))
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