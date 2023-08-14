import java.util.*

fun main() {
    val s = Stack<Int>()
    var n = i()
    val sb = StringBuilder()
    while (n-- > 0) {
        when (i()) {
            1 -> s.push(i())
            2 -> sb.append(if (s.isEmpty()) "-1" else s.pop()).append('\n')
            3 -> sb.append(s.size).append('\n')
            4 -> sb.append(if (s.isEmpty()) "1\n" else "0\n")
            5 -> sb.append(if (s.isEmpty()) "-1" else s.peek()).append('\n')
        }
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
