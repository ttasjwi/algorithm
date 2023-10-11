fun main() {
    val n = i()
    var bus = i()
    val inf = 10_000_000
    val cost = Array(n) { i -> IntArray(n) { j -> if (i == j) 0 else inf } }
    var a: Int
    var b: Int
    var c: Int
    while (bus -- > 0) {
       a = i() - 1
       b = i() - 1
       c = i()
       if (cost[a][b] > c) cost[a][b] = c
    }
    var alt: Int
    for (m in 0 until n) {
        for (s in 0 until n) {
            if (s == m || cost[s][m] == inf) continue
            for (e in 0 until n) {
                if (s == e || m == e || cost[m][e] == inf) continue
                alt = cost[s][m] + cost[m][e]
                if (cost[s][e] > alt) cost[s][e] = alt
            }
        }
    }
    for (s in 0 until n) {
        for (e in 0 until n) {
            writeInt(cost[s][e].let { if (it == inf) 0 else it })
            writeByte(ASCII_space)
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