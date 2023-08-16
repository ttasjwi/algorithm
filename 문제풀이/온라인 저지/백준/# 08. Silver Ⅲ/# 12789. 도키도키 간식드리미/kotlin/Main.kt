fun main() {
    var n = i()
    val stack = IntArray(n)
    var v: Int
    var p = 0
    var target = 1
    while (n-- > 0) {
        v = i()
        if (v == target) {
            target++
            while (p > 0 && stack[p - 1] == target) {
                target += 1
                p--
            }
        } else {
            stack[p++] = v
        }
    }
    println(if (p > 0) "Sad" else "Nice")
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
