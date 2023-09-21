fun main() {
    val n = i()
    val m = i()
    if (n >= m) {
        print(n - m)
        return
    }
    val c = 2 * m + 1
    val check = BooleanArray(c)
    val q = IntArray(c)
    var f = 0
    var r = 1
    var s = 1
    q[1] = n
    check[n] = true
    var size: Int
    var cur: Int
    var next: Int
    var depth = -1
    loop@while(s > 0) {
        size = s
        depth ++
        while (size -->0) {
            cur = q[((f+1+c)%c).also { f = it }]
            s --
            for (i in 0..2) {
                next = when (i) {
                    0 -> cur - 1
                    1 -> cur + 1
                    else -> cur * 2
                }
                if (next == m) {depth += 1; break@loop}
                if (next in 0..c-1 && !check[next]) {
                    check[next] = true
                    q[((r + 1 + c)%c).also {r = it}] = next
                    s++
                }
            }
        }
    }
    print(depth)
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
