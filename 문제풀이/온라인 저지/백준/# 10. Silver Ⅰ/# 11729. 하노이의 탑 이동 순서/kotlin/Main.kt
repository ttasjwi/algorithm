val sb = StringBuilder()
var cnt = 0
fun main() {
    val n = i()
    hanoi(n, '1', '3', '2')
    println(cnt)
    print(sb)
}

private fun hanoi(n: Int, from: Char, to: Char, by: Char) {
    if (n == 1) {
        sb.append(from).append(' ').append(to).append('\n')
        cnt ++
        return
    }
    hanoi(n-1, from, by, to)
    sb.append(from).append(' ').append(to).append('\n')
    cnt ++
    hanoi(n-1, by, to, from)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
