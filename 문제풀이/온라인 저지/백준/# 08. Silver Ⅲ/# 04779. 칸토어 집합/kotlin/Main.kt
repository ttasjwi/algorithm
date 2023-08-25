import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
val ssb = StringBuilder()

fun main() {
    buildString {  }
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n: Int
    var len: Int
    while (true) {
        n = br.readLine()?.toInt() ?: break
        len = Math.pow(3.0, n.toDouble()).toInt()
        for (i in 0 until len) ssb.append('-')
        foo(0, len)
        sb.append(ssb).append('\n')
        ssb.setLength(0)
    }
    print(sb)
}

fun foo(start: Int, len: Int) {
    if (len == 1) return
    if (len == 3) {ssb[start+1] = ' '; return}
    for (i in start+len/3 until start+(len*2)/3) ssb[i] = ' '
    foo(start, len/3)
    foo(start + (len*2)/3, len/3)
}
