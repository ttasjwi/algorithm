fun main() {
    var t = i()
    var n: Int
    var x: Int
    var y: Int
    var minTime: Double
    var time: Double
    var speed = -1
    var lt: Int
    var rt: Int
    var mid: Int
    var answer: Int

    loop@ while (t-- > 0) {
        n = i()
        x = i()
        y = i()
        minTime = Double.MAX_VALUE
        while (n-- > 0) {
            speed = i()
            time = x / speed.toDouble()
            if (minTime > time) {
                if (n == 0) {
                    writeInt(0)
                    continue@loop
                }
                minTime = time
            }
        }
        lt = 1
        rt = y
        answer = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            time = if (x < mid) x / mid.toDouble() else 1 + (x - mid) / speed.toDouble()
            if (minTime > time) {
                answer = mid
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        writeInt(answer)
    }
    flushBuffer()
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

private fun i(): Int {
    var v = 0
    var c = r()
    val n = c == ASCII_minus
    c = if (n) r() else c
    do {
        v = v * 10 + c - 48
    } while (isDigit(r().also { c = it }))
    return if (n) -v else v
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
    writeByte(ASCII_n)
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