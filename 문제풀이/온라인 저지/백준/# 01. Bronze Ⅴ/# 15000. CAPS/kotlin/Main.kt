fun main() {
    var c: Byte
    while(!isSpace(r().also { c = (it-32).toByte() })) {
        writeByte(c)
    }
    flushBuffer()
}

private const val EOF = -1
private const val ASCII_space: Byte = 32
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(65536)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0

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

private fun writeByte(b: Byte) {
    if (outbufferpointer == outbuffer.size) flushBuffer()
    outbuffer[outbufferpointer++] = b
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