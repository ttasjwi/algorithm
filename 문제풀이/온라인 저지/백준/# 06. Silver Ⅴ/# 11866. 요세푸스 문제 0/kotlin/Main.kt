import java.util.LinkedList

fun main() {
    val n = i()
    val k = i()
    val l = LinkedList<Int>()
    for (i in 1..n) l.add(i)
    var idx = 0
    val sb = StringBuilder()
    sb.append('<')
    while (!l.isEmpty()) {
        idx = (idx - 1 + k + l.size) % l.size
        sb.append(l.removeAt(idx)).append(',').append(' ')
    }
    sb.deleteRange(sb.length - 2, sb.length)
    sb.append('>')
    print(sb)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
