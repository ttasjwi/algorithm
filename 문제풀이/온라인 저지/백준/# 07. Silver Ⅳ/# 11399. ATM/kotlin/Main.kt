fun main() {
    var n = i()
    var sum = 0
    val counter = IntArray(1001)
    var min = 1000
    var max = 1
    while (n-- > 0) {
        counter[i().also {
            if (min > it) min = it
            if (max < it) max = it
        }] ++
    }
    var cur = 0
    for (i in min..max) {
        while (counter[i] > 0) {
            cur += i
            sum += cur
            counter[i] --
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