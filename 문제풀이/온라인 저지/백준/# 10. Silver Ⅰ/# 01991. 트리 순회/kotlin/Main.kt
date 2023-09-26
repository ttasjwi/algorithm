fun main() {
    val n = i()
    val child = Array(n+1){IntArray(2)}
    var p: Int
    var lt: Int
    var rt: Int
    for (i in 0 until n) {
        p = r() - 64
        r()
        lt = r() - 64
        r()
        rt = r() - 64
        r()
        if (lt >= 1) child[p][0] = lt
        if (rt >= 1) child[p][1] = rt
    }
    val sb = StringBuilder()
    fun first(node: Int) {
        sb.append((node+64).toChar())
        if (child[node][0] >= 1) first(child[node][0])
        if (child[node][1] >= 1) first(child[node][1])
    }
    fun mid(node: Int) {
        if (child[node][0] >= 1) mid(child[node][0])
        sb.append((node+64).toChar())
        if (child[node][1] >= 1) mid(child[node][1])
    }
    fun last(node: Int) {
        if (child[node][0] >= 1) last(child[node][0])
        if (child[node][1] >= 1) last(child[node][1])
        sb.append((node+64).toChar())
    }
    first(1)
    sb.append('\n')
    mid(1)
    sb.append('\n')
    last(1)
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
