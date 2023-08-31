fun main() {
    val n = i()
    when (n) {
        1 -> print(i())
        2 -> print(i() + i())
        else -> {
            val a = IntArray(n)
            val d = IntArray(n)
            for (i in a.indices) {
                a[i] = i()
            }
            d[n - 1] = a[n - 1]
            d[n - 2] = a[n - 2] + a[n - 1]
            d[n - 3] = maxOf(a[n - 3] + a[n - 2], a[n - 2] + a[n - 1], a[n - 3] + a[n - 1])

            for (s in n - 4 downTo 0) {
                d[s] = maxOf(a[s] + d[s + 2], a[s] + a[s + 1] + d[s + 3], d[s + 1])
            }
            print(d[0])
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