fun main() {
    var k = i()
    val cap = 1 shl k
    val tree = IntArray(cap)

    fun search(x: Int) {
        val lt = x shl 1
        if (lt < cap && tree[lt] == 0) search(lt)
        tree[x] = i()
        val rt = lt + 1
        if (rt < cap && tree[rt] == 0) search(rt)
    }
    search(1)
    var start: Int
    var end = 0
    while (k-- > 0) {
        start = end + 1
        end = (start shl 1) - 1
        for (i in start..end) {
            writeInt(tree[i])
        }
        writeByte(ASCII_n)
    }
    flushBuffer()
}

private const val EOF = -1
private const val ASCII_n: Byte = 10
private const val ASCII_space: Byte = 32
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(5125)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(5120)
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
    writeByte(ASCII_space)
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