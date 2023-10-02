private const val EOF = -1
private const val ASCII_n: Byte = 10
private const val ASCII_space: Byte = 32
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
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (isDigit(r().also { c = it }))
    return v
}

private fun i() : Int {
    var v = 0
    var c = r()
    val n = c == ASCII_minus
    c = if (n) r() else c
    do { v = v * 10 + c - 48 } while (isDigit(r().also { c = it }))
    return if (n) -v else v
}

private fun s() : String {
    var c = r()
    do rsb.append(c.toChar()) while (!isSpace(r().also { c = it }))
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (inbufferpointer == bytesread) fillBuffer()
    return if (bytesread == EOF) EOF.toByte() else inbuffer[inbufferpointer++]
}

private fun fillBuffer() {
    try {
        bytesread = din.read(inbuffer, 0.also { inbufferpointer = it }, inbuffer.size)
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

private fun writeStr(s: String) {
    for (ch in s) {
        writeByte(ch.toByte())
    }
}

private fun writeChar(ch: Char) {
    writeByte(ch.toByte())
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

private fun writeSpace() {
    writeByte(ASCII_space)
}

private fun writeN() {
    writeByte(ASCII_n)
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        try {
            dout.write(outbuffer, 0, outbufferpointer)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        outbufferpointer = 0
    }
}

private fun isSpace(b: Byte) = b <= ASCII_space
private fun isDigit(b: Byte) = b >= ASCII_0
private fun isEOF() = bytesread == EOF