private const val O: Byte = 79

fun main() {
    val n = i()
    var m = i()
    val score = IntArray(n)
    for (i in 0 until n) {
        score[i] = i()
    }

    var answerId = 100001
    var answerSum = -1

    var id: Int
    var sum: Int
    var mark: Byte

    while (m-- > 0) {
        id = i()
        sum = 0
        for (i in 0 until n) {
            mark = r()
            r()
            if (mark == O) {
                sum += score[i]
            }
        }
        if (sum > answerSum) {
            answerSum = sum
            answerId = id
        } else if (sum == answerSum && answerId > id) {
            answerId = id
        }
    }
    writeInt(answerId)
    writeByte(ASCII_space)
    writeInt(answerSum)
    flushBuffer()
}

private const val EOF = -1
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
