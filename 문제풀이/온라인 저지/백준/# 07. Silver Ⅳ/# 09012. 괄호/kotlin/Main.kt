fun main() {
    var t = i()
    var p: Int
    val stack = CharArray(50)
    val sb = StringBuilder()
    loop@while (t-- > 0) {
        s()
        p = 0
        for (ch in rsb) {
            if (ch == '(') {
                stack[p++] = ch
            } else if (p == 0) {
                sb.append("NO\n")
                continue@loop
            } else {
                p--
            }
        }
        sb.append(if (p ==0) "YES\n" else "NO\n")
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

private fun s(): StringBuilder {
    rsb.setLength(0)
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    return rsb
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
