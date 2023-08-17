import java.util.*

fun main() {
    val q = LinkedList<Int>()
    var n = i()
    val sb = StringBuilder()
    while (n-- > 0) {
        sb.append(when(c()) {
            'o' -> if (q.isEmpty()) -1 else q.poll()
            'i' -> q.size
            'm' -> if (q.isEmpty()) 1 else 0
            'r' -> if (q.isEmpty()) -1 else q.peek()
            'a' -> if (q.isEmpty()) -1 else q.peekLast()
            else -> {q.offer(i()); continue}
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

private fun c(): Char {
    r()
    val c = r()
    while (r() > 96);
    return c.toChar()
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}