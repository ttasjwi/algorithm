import kotlin.math.sqrt

fun main() {
    var t = i()
    while (t-- >0) {
        writeLong(goePrimeNumber(i()))
        writeByte(ASCII_n)
    }
    flushBuffer()
}

fun goePrimeNumber(i: Long): Long {
    var num = i
    while (true) {
        if (isPrimeNumber(num)) {
            break
        }
        num ++
    }
    return num
}

fun isPrimeNumber(num: Long): Boolean {
    if (num == 0L) return false
    if (num == 1L) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num%i == 0L) return false
    }
    return true
}

private const val EOF = -1
private const val ASCII_n: Byte = 10
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

private fun writeLong(i: Long) {
    var i = i
    if (i == 0L) {
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
