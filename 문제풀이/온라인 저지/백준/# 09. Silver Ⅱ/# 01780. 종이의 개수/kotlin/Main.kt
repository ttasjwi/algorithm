fun main() {
    val n = i()
    val board = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            board[i][j] = i()
        }
    }
    var m = 0
    var z = 0
    var p = 0
    fun div(sr: Int, sc: Int, len: Int) {
        for (r in sr until sr + len) {
            for (c in sc until sc + len) {
                if (board[r][c] != board[sr][sc]) {
                    val nLen = len/3
                    for (i in 0 until 3) {
                        for (j in 0 until 3) {
                            if (nLen == 1) {
                                when (board[sr+i][sc+j]) {
                                    -1 -> m++
                                    0 -> z++
                                    1 -> p++
                                }
                            } else {
                                div(sr+nLen*i, sc+nLen*j, nLen)
                            }
                        }
                    }
                    return
                }
            }
        }
        when (board[sr][sc]) {
            -1 -> m++
            0 -> z++
            1 -> p++
        }
    }
    div(0,0, n)
    val sb = StringBuilder()
    sb.append(m).append('\n').append(z).append('\n').append(p)
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
    val n = c.toInt() == 45
    c = if (n) r() else c
    do {
        v = v * 10 + c - 48
    } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
