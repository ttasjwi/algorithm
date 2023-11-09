private const val R: Byte = 82
private const val P: Byte = 80

fun main() {
    var t = i()
    while (t-- > 0) {
        var n = i()
        var s1 = 0
        var s2 = 0
        while (n -- > 0) {
            val p1 = r()
            r()
            val p2 = r()
            r()

            if (p1 == p2) continue
            else if (p1 == R) {
                if (p2 == P) {
                    s2 ++
                } else {
                    s1 ++
                }
            } else if (p1 == P) {
                if (p2 == R) {
                    s1 ++
                } else {
                    s2 ++
                }
            } else {
                if (p2 == R) {
                    s2 ++
                } else {
                    s1 ++
                }
            }
        }
        if (s1 == s2) {
            writeStr("TIE\n")
        } else if (s1 > s2) {
            writeStr("Player 1\n")
        } else {
            writeStr("Player 2\n")
        }
    }
    flushBuffer()
}

private const val EOF = -1
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

private fun writeStr(s: String) {
    for (ch in s) {
        writeByte(ch.toByte())
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
