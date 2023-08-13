import kotlin.math.sqrt

fun main() {
    var t = i()
    val m = 1_000_000
    val check = BooleanArray(m + 1)
    check[0] = true; check[1] = true
    for (i in 2..sqrt(m.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2 * i..m step i) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    var cnt: Int
    var n: Int
    while (t-- > 0) {
        n = i()
        cnt = 0
        for (i in 2..n / 2) {
            if (!check[i] && !check[n - i]) {
                cnt ++
            }
        }
        sb.append(cnt).append('\n')
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

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
