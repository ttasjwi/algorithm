fun main() {
    var t = i()
    val sb = StringBuilder()
    var a: Int
    var b: Int
    var tmp: Int
    while (t-- > 0) {
        a = i()
        b = i()
        if (a < b) {
            tmp = a
            a = b
            b = tmp
        }
        sb.append(lcm(a,b)).append('\n')
    }
    print(sb)
}

private fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a,b)
}

private fun gcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b else gcd(b, r)
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
