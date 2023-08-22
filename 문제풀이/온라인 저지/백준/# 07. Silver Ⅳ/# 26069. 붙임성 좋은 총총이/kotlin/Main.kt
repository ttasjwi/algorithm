fun main() {
    var n = i()
    val set = HashSet<String>()
    set += "ChongChong"
    var a: String
    var b: String
    while (n-- > 0) {
        a = s()
        b = s()

        if (a in set) {
            set += b
        } else if (b in set) {
            set += a
        }
    }
    print(set.size)
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
