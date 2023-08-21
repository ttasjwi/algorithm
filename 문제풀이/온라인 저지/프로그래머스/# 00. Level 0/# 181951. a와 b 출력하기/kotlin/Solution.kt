fun main(args: Array<String>) {
    val a = i()
    val b = i()
    val sb = StringBuilder()
    sb.append('a').append(' ').append('=').append(' ').append(a).append('\n')
        .append('b').append(' ').append('=').append(' ').append(b)
    println(sb)
}


private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    val n = c == 45
    c = if (n) System.`in`.read() else c
    do { v = v * 10 + c - 48 } while (System.`in`.read().also { c = it } > 47)
    return if (n) -v else v
}
