fun main() {
    val n = i()

    val items = IntArray(n)
    for (i in 0 until n) {
        items[i] = i().let { if (it == 1) -1 else it }
    }

    var input: Int
    for (i in 0 until n) {
        input = i()
        if (items[i] == 0) items[i] = input
    }

    val m = i()
    var x: Int
    var tmp: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        for (j in 0 until n) {
            if (items[j] > 0) {
                tmp = items[j]
                items[j] = x
                x = tmp
            }
        }
        sb.append(x).append(' ')
    }
    print(sb)
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