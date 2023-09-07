fun main() {
    var answer = 0
    var sum = 0
    var v = 0
    var c: Byte
    var m = false
    while (true) {
        c = r()
        when {
            c <= 10 ->  {
                sum += v
                answer += if (m) -sum else sum
                break
            }
            c <= 43 -> {
                sum += v.also { v = 0 }
            }
            c <= 45 -> {
                sum += v.also { v = 0 }
                answer += if (m) -sum else sum
                m = true
                sum = 0
            }
            else -> {
                v = v * 10 + c - 48
            }
        }
    }
    print(answer)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
