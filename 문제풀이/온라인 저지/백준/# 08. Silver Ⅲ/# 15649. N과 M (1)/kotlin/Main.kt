var n = 0
var m = 0
lateinit var c: BooleanArray
lateinit var arr: CharArray
val sb = StringBuilder()

fun main() {
    n = i()
    m = i()
    arr = CharArray(2 * m)
    for (i in 0 until m) arr[2*i + 1] = ' '
    arr[2 * m - 1] = '\n'
    c = BooleanArray(n + 1)
    bt(0)
    print(sb)
}

private fun bt(idx: Int) {
    if (idx == m) { sb.append(arr);return }
    for (i in 1..n) {
        if (!c[i]) {
            c[i] = true
            arr[idx * 2] = (i + 48).toChar()
            bt(idx + 1)
            c[i] = false
        }
    }
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
