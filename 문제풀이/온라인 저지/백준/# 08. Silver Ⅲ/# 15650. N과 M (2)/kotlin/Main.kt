var n = 0
var m = 0
lateinit var arr: CharArray
val sb = StringBuilder()

fun main() {
    n = i()
    m = i()
    arr = CharArray(2 * m) {' '}
    arr[2 * m - 1] = '\n'
    bt(0, 1)
    print(sb)
}

private fun bt(idx: Int, start: Int) {
    if (idx == m) {
        sb.append(arr);return
    }
    for (i in start..n) {
        arr[idx * 2] = (i + 48).toChar()
        bt(idx + 1, i + 1)
    }
}
private const val S = 4
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
