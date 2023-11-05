fun main() {
    val t = i()
    var y: Int
    var k: Int
    repeat(t) {
        y = 0
        k = 0
        repeat(9) {
            y += i()
            k += i()
        }
        writeStr(
            when {
                (y>k) -> "Yonsei"
                (y<k) -> "Korea"
                else -> "Draw"
            }
        )
        writeByte(ASCII_n)
    }
    flushBuffer()
}

private const val EOF = -1
private const val ASCII_n: Byte = 10
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(65536)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0

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

private fun writeStr(s: String) {
    for (ch in s) {
        writeByte(ch.toByte())
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
