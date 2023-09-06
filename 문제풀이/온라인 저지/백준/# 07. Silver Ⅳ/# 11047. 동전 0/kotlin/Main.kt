fun main() {
    val n = i()
    var k = i()
    val units = IntArray(n)
    for (i in 0..n-1) {
        units[n-1-i] = i()
    }
    var answer = 0
    for (unit in units) {
        if (k == 0) break
        k = (k%unit).also { answer += k/unit }
    }
    print(answer)
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