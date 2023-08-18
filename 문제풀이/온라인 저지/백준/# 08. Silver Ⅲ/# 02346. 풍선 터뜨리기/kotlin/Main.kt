import java.util.LinkedList

fun main() {
    val n = i()
    val l = LinkedList<IntArray>()
    for (i in 1..n) {
        l.add(intArrayOf(i, i()))
    }
    val sb = StringBuilder()
    var idx = 0
    var item = l.removeAt(idx)
    sb.append(item[0]).append(' ')

    while (!l.isEmpty()) {
        if (item[1] > 0) idx--
        idx = (idx + item[1] + l.size)%l.size
        while (idx < 0) idx += l.size
        item = l.removeAt(idx)
        sb.append(item[0]).append(' ')
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
    val n = c.toInt() == 45
    c = if (n) r() else c
    do {
        v = v * 10 + c - 48
    } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}