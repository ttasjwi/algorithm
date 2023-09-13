fun main() {
    val counter = IntArray(20_000_001)
    var n = i()
    while (n-- > 0) {
        counter[i() + 10_000_000]++
    }
    var m = i()
    val sb = StringBuilder()
    while (m-- > 0) {
        sb.append(counter[i() + 10_000_000]).append(' ')
    }
    print(sb)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    val n = c == 45
    c = if (n) System.`in`.read() else c
    do v = v * 10 + c - 48 while (System.`in`.read().also { c = it } > 47)
    return if (n) -v else v
}
