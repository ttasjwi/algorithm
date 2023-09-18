fun main() {
    val c = IntArray(26)
    while(r().also {
            if (it >= 97) c[it - 97] ++
            else if (it >= 65) c[it - 65] ++
        } >= 65);

    var maxCnt = -1
    var answer = ' '
    for (i in c.indices) {
        if (c[i] > maxCnt) {
            maxCnt = c[i]
            answer = (i + 65).toChar()
        } else if (c[i] == maxCnt) {
            answer = '?'
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
