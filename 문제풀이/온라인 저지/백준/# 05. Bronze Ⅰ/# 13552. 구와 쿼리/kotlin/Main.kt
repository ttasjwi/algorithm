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
private val bytebuffer = ByteArray(20)

fun main() {
    val points = Array(i().toInt()) { longArrayOf(i(), i(), i())}
    val m = i().toInt()

    while (m -- > 0) {
        val x = i()
        val y = i()
        val z = i()
        val rr = i().let { it * it }
        var count = 0
        for (arr in points) {
            val a = arr[0]
            val b = arr[1]
            val c = arr[2]

            val s = (x - a).let { it * it } + (y -b).let { it * it} + (z -c).let { it * it }
            if ( s <= rr) {
                count ++
            }
        }
        writeInt(count)
        writeN()
    }
    flushBuffer()
}

private fun i(): Long {
    var v = 0L
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

private fun writeN() {
    writeByte(ASCII_n)
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        dout.write(outbuffer, 0, outbufferpointer)
        outbufferpointer = 0
    }
}

private fun isDigit(b: Byte) = b >= ASCII_0
