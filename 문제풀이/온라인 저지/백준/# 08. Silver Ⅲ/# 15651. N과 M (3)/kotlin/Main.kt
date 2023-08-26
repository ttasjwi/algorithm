import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val n = i()
    val m = i()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = CharArray(2 * m) {' '}
    arr[2 * m - 1] = '\n'

    fun bt(idx: Int) {
        if (idx == m) { bw.write(arr);return}
        for (i in 1..n) {
            arr[idx * 2] = (i + 48).toChar()
            bt(idx + 1)
        }
    }
    bt(0)
    bw.flush()
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
