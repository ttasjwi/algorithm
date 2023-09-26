fun main() {
    val n = i()
    val arr = IntArray(n)
    val check = BooleanArray(1_000_001)
    for (i in 0 until n) {
        arr[i] = i()
    }
    val x = i()
    var cnt = 0
    for (e in arr) {
        if (x-e in 1..1_000_000 && check[x-e]) {
            cnt ++
        } else {
            check[e] = true
        }
    }
    print(cnt)
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