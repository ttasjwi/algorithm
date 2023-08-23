private val sb = StringBuilder()

fun main() {
    var t = i()
    while (t-- > 0) s()
    print(sb)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()

private var lt = 0
private var rt = 0
private var pd = 0
private var cnt = 0


private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s() {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    lt = 0
    rt = rsb.length - 1
    cnt = 0
    pd = 1
    while (true) {
        cnt ++
        if (lt >= rt) break
        if (rsb[lt] != rsb[rt]) {pd = 0; break}
        lt ++
        rt --
    }
    sb.append(pd).append(' ').append(cnt).append('\n')
    rsb.setLength(0)
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}