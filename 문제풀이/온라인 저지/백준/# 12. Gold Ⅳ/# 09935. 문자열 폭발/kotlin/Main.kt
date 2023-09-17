fun main() {
    val s = s()
    val x = s()
    val st = CharArray(s.length)
    var top = -1
    var p = -1
    for (ch in s) {
        st[++top] = ch

        if (st[top] != x[p+1]) {
            p = if (st[top] == x[0]) 0 else - 1
        } else {
            p ++
            if (p == x.length - 1) {
                top -= x.length
                p = -1
                if (top == -1) continue
                for (i in Math.max(0, top-x.length+1)..top) {
                    if (st[i] != x[p+1]) {
                        p = if (st[i] == x[0]) 0 else - 1
                    } else {
                        p ++
                    }
                }
            }
        }
    }
    if (top == -1) {
        print("FRULA")
    } else {
        for (i in 0..top) {
            sb.append(st[i])
        }
        print(sb)
    }
}

private const val S = 65536
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
