fun main() {
    val a = l()
    val b = l()
    print(if (a >= b) lcm(a, b) else lcm(b, a))
}

private fun lcm(a:Long, b:Long) : Long {
    return a * b / gcd(a,b)
}

private fun gcd(a:Long, b:Long) : Long {
    val r = a % b
    return if (r == 0L) b else gcd(b, r)
}
private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun l(): Long {
    var v = 0L
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
