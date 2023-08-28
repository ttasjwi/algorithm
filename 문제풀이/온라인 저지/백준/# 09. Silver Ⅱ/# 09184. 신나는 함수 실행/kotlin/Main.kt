val w = Array(21) {Array(21) {IntArray(21)}}

fun main() {
    var a: Int
    var b: Int
    var c: Int
    val sb = StringBuilder()
    w[0][0][0] = 1
    while(true) {
        a = i()
        b = i()
        c = i()
        if (a == -1 && b == -1 && c == -1) {
            break
        }
        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
            .append(w(a,b,c)).append('\n')
    }
    print(sb)
}

private fun w(a: Int, b:Int, c:Int): Int{
    return when {
        a <= 0 || b <= 0 || c<=0 -> w[0][0][0]
        a > 20 || b > 20 || c > 20 -> w(20, 20, 20)
        w[a][b][c] > 0 -> w[a][b][c]
        a<b && b<c -> (w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c)).also { w[a][b][c] = it }
        else -> (w(a-1,b,c) +w(a-1, b-1, c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)).also { w[a][b][c] = it }
    }
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
    do { v = v * 10 + c - 48 } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}