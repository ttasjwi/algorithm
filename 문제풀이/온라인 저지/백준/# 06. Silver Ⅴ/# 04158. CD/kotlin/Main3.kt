fun main() {
    var n: Int
    var m: Int
    var items: IntArray
    var cur: Int
    var cnt: Int
    var lt: Int
    var rt: Int
    var mid: Int
    while (true) {
        n = i()
        m = i()
        if (n == 0 && m == 0) break
        items = IntArray(n)
        cnt = 0
        for (i in 0 until n) {
            items[i] = i()
        }
        for (i in 0 until m) {
            cur = i()
            lt = 0
            rt = n-1
            while (lt <= rt) {
                mid = (lt + rt) shr 1
                if (items[mid] == cur) {
                    cnt ++
                    break
                } else if (items[mid] < cur) {
                    lt = mid + 1
                } else {
                    rt = mid - 1
                }
            }
        }
        writeInt(cnt)
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