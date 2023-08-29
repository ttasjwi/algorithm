fun main() {
    val n = i()
    var input: Int
    var max = -1001
    var current = 0 // 임의의 값에서 시작해서 누적했을 때, 현 시점에서 최대가 되는 연속합
    for (i in 1..n) {
        input = i()
        current = if (current + input > input) current + input else input
        max = if (current > max) current else max // 연속합의 최댓값
    }
    print(max)
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