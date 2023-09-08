fun main() {
    val n = i()
    val board = Array(n) { BooleanArray(n) }
    var wh = 0
    var bl = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            board[i][j] = b()
        }
    }
    fun div(sr:Int, sc:Int, len: Int) {
        for (r in sr until sr+len) {
            for (c in sc until sc+len) {
                if (board[r][c] != board[sr][sc]) {
                        val nLen = len/2
                        div(sr, sc, nLen)
                        div(sr, sc+nLen, nLen)
                        div(sr+nLen, sc, nLen)
                        div(sr+nLen, sc+nLen, nLen)
                        return
                }
            }
        }
        if (board[sr][sc]) bl ++ else wh ++
    }
    div(0, 0, n)
    val sb = StringBuilder()
    sb.append(wh).append('\n').append(bl)
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

private fun b(): Boolean {
    return (r() >= 49).also { r(); }
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}