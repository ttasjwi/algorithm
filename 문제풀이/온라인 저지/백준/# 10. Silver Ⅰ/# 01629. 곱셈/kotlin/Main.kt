fun main() {
    val a = i()
    val b = i()
    val c = i().toLong()

    fun div(x: Int): Long {
        if (x == 0)
            return 1
        if (x == 1)
            return a % c

        val t = div(x / 2)

        return if (x % 2 == 0)
            (t * t) % c
        else
            ((t * t) % c * a % c)%c
    }
    print(div(b))
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