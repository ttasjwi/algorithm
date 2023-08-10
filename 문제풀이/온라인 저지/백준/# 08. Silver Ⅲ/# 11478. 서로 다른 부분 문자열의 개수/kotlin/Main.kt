fun main() {
    val s = s()
    val set = HashSet<String>()

    var lt = 0
    var rt = 0

    while (lt < s.length) {
        while (rt < s.length) {
            sb.append(s[rt])
            set.add(sb.toString())
            rt ++
        }
        sb.setLength(0)
        lt ++
        rt = lt
    }
    print(set.size)
}


private const val S = 1001
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val sb = StringBuilder()

private fun s(): String {
    var c = r()
    do sb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = sb.toString()
    sb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
