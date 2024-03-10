fun main() {
    val n = i()
    var nums: IntArray
    var maxPersonNumber = 0
    var maxSumEnd = 0
    var sumEnd: Int
    for (x in 1..n) {
        nums = IntArray(5)
        for (i in 0 until 5) {
            nums[i] = i()
        }
        for (i in 0 until 5) {
            for (j  in i+1 until 5) {
                for (k in j+1 until 5) {
                    sumEnd = (nums[i] + nums[j] + nums[k])%10
                    if (sumEnd >= maxSumEnd) {
                        maxSumEnd = sumEnd
                        maxPersonNumber = x
                    }
                }
            }
        }
    }
    writeInt(maxPersonNumber)
    flushBuffer()
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
