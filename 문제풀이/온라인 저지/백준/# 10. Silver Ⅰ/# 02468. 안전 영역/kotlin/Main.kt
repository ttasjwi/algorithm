private val direction = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

private var n = 0
private lateinit var board: Array<IntArray>
private lateinit var check: Array<BooleanArray>

fun main() {
    n = i()
    board = Array(n) { IntArray(n) }
    var minHeight = 101
    var maxHeight = -1
    for (r in 0 until n) {
        for (c in 0 until n) {
            board[r][c] = i()
            if (board[r][c] > maxHeight) maxHeight = board[r][c]
            if (board[r][c] < minHeight) minHeight = board[r][c]
        }
    }
    var answer = 0
    var cnt: Int
    for (rainHeight in minHeight - 1 until maxHeight) {
        check = Array(n) { BooleanArray(n) }
        cnt = 0
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (board[r][c] > rainHeight && !check[r][c]) {
                    check[r][c] = true
                    cnt++
                    dfs(r, c, rainHeight)
                }
            }
        }
        if (cnt > answer) answer = cnt
    }
    writeInt(answer)
    flushBuffer()
}

private fun dfs(r: Int, c: Int, rainHeight: Int) {
    var nr: Int
    var nc: Int
    for (d in direction) {
        nr = r + d[0]
        nc = c + d[1]

        if (nr in 0 until n && nc in 0 until n && board[nr][nc] > rainHeight && !check[nr][nc]) {
            check[nr][nc] = true
            dfs(nr, nc, rainHeight)
        }
    }
}

private const val EOF = -1
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(65536)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(20)

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (isDigit(r().also { c = it }))
    return v
}

private fun r(): Byte {
    if (inbufferpointer == bytesread) fillBuffer()
    return if (bytesread == EOF) EOF.toByte() else inbuffer[inbufferpointer++]
}

private fun fillBuffer() {
    bytesread = din.read(inbuffer, 0.also { inbufferpointer = it }, inbuffer.size)
}

private fun writeInt(i: Int) {
    var i = i
    if (i == 0) {
        writeByte(ASCII_0)
    } else {
        if (i < 0) {
            writeByte(ASCII_minus)
            i = -i
        }
        var index = 0
        while (i > 0) {
            bytebuffer[index++] = (i % 10 + ASCII_0).toByte()
            i /= 10
        }
        while (index-- > 0) {
            writeByte(bytebuffer[index])
        }
    }
}

private fun writeByte(b: Byte) {
    if (outbufferpointer == outbuffer.size) flushBuffer()
    outbuffer[outbufferpointer++] = b
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        dout.write(outbuffer, 0, outbufferpointer)
        outbufferpointer = 0
    }
}

private fun isDigit(b: Byte) = b >= ASCII_0
