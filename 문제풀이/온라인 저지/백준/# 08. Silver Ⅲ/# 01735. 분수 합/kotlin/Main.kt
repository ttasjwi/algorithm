fun main() {
    val a1 = i()
    val b1 = i()
    val a2 = i()
    val b2 = i()

    val a = a1 * b2 + a2 * b1
    val b = b1 * b2
    val gcd = if (a>=b) gcd(a,b) else gcd(b,a)
    val sb = StringBuilder()
    sb.append(a/gcd).append(' ').append(b/gcd)
    print(sb)
}

fun gcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b else gcd(b, r)
}

private const val S = 24
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
