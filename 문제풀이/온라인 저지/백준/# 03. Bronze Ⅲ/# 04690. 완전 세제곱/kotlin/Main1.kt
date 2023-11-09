fun main() {
    for (a in 5..100) {
        for (b in 2..a - 3) {
            for (c in b + 1..a - 2) {
                for (d in c + 1..a - 1) {
                    if (a * a * a == b * b * b + c * c * c + d * d * d) {
                        writeStr("Cube = ")
                        writeInt(a)
                        writeStr(", Triple = (")
                        writeInt(b)
                        writeChar(',')
                        writeInt(c)
                        writeChar(',')
                        writeInt(d)
                        writeChar(')')
                        writeByte(ASCII_n)
                    }
                }
            }
        }
    }
    flushBuffer()
}

private const val ASCII_n: Byte = 10
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val dout = java.io.DataOutputStream(System.out)
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(20)

private fun writeStr(s: String) {
    for (ch in s) {
        writeByte(ch.toByte())
    }
}

private fun writeChar(ch: Char) {
    writeByte(ch.toByte())
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
