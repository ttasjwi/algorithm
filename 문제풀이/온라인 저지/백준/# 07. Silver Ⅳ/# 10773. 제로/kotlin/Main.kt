fun main() {
    var k = i()
    var input: Int
    val stack = IntArray(k)
    var p = 0
    var sum = 0
    while (k-- > 0) {
        input = i()
        if (input == 0) {
            sum -= stack[--p]
        } else {
            sum += input
            stack[p++] = input
        }
    }
    print(sum)
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
