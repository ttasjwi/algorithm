fun main() {
    val n = i()
    val d = IntArray(n - 1)

    for (i in 0..n - 2) d[i] = i()
    val c = IntArray(n)
    for (i in 0..n - 2) c[i] = i()
    i()
    var lt = 0
    var rt: Int
    var answer = 0L
    while (lt < n - 1) {
        rt = lt + 1
        while (rt < n && c[lt] < c[rt]) {
            answer += c[lt].toLong() * d[rt - 1]
            rt++
        }
        answer += c[lt].toLong() * d[rt - 1]
        lt = rt
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