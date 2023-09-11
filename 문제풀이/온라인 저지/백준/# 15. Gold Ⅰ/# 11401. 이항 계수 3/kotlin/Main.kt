fun main() {
    val n = i()
    val k = i()
    val c = 1_000_000_007
    when (k) {
        n, 0 -> {
            print(1)
        }
        1, n - 1 -> {
            print(n)
        }
        else -> {
            var top = 1L
            var bottom = 1L

            for (i in 1..n) {
                top = (top * i) % c
                if (i == n - k) bottom *= top
                if (i == k) bottom *= top
            }
            bottom %= c
            fun div(x: Int): Long {
                if (x == 0)
                    return 1
                if (x == 1)
                    return bottom % c
                val t = div(x shr 1)

                return if (x % 2 == 0)
                    (t * t) % c
                else
                    (t * t) % c * bottom % c
            }
            print(top * div(c - 2) % c)
        }
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