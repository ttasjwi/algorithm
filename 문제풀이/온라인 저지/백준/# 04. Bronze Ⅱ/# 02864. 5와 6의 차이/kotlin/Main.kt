fun main() {
    val a = i()
    val b = i()
    writeInt(a[0] + b[0])
    writeInt(a[1] + b[1])
    flushBuffer()
}

private const val EOF = -1
private const val ASCII_space: Byte = 32
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(16)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(16)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(16)

private fun i(): IntArray {
    var min = 0
    var max = 0
    var c: Int
    while (isDigit(r().also { c = it.toInt() })) {
        min = min * 10 + if (c == 54) 5 else c - 48
        max = max * 10 + if (c == 53) 6 else c - 48
    }
    return intArrayOf(min, max)
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
        writeByte(ASCII_space)
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