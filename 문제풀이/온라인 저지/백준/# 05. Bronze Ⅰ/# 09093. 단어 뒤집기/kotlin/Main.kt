fun main() {
    var t = i()
    val stack = Stack()

    fun s() {
        var c = r()
        var sep = ASCII_space
        do stack.push(c) while (!isSpace(r().also { c = it; if (isN(c)) {t--; sep = c} }))
        while(stack.isNotEmpty()) writeByte(stack.pop())
        writeByte(sep)
    }
    while(t > 0) s()
    flushBuffer()
}

class Stack {

    private var size = 0
    private val arr = ByteArray(20)

    fun push(b: Byte) {
        arr[size++] = b
    }

    fun pop() = arr[--size]

    fun isNotEmpty() = size != 0
}

private const val EOF = -1
private const val ASCII_n: Byte = 10
private const val ASCII_space: Byte = 32
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

private fun isSpace(b: Byte) = b <= ASCII_space
private fun isN(b: Byte) = b <= ASCII_n
private fun isDigit(b: Byte) = b >= ASCII_0
