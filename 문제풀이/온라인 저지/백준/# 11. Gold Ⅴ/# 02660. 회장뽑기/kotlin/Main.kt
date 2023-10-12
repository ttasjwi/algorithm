fun main() {
    val n = i()
    val inf = 50
    val cost = Array(n+1) { IntArray(n+1) { inf } }
    var a: Int
    var b: Int
    while(true) {
        a = i()
        b = i()
        if (a == - 1) break
        cost[a][b] = 1
        cost[b][a] = 1
    }

    var alt: Int
    for (m in 1..n) {
        for (s in 1..n) {
            if (cost[s][m] == inf) continue
            for (e in 1..n) {
                if (s == e || cost[m][e] == inf) continue
                alt = cost[s][m] + cost[m][e]
                if (cost[s][e] > alt) {
                    cost[s][e] = alt
                }
            }
        }
    }
    var size = 0
    val stack = IntArray(inf)
    var minScore = inf
    var currentMaxScore: Int
    for (r in n downTo 1) {
        currentMaxScore = 0
        for (c in n downTo 1) {
            if (cost[r][c] != inf && currentMaxScore < cost[r][c]) {
                currentMaxScore = cost[r][c]
            }
        }
        if (currentMaxScore != 0 && currentMaxScore <= minScore) {
            if (currentMaxScore < minScore) {
                size = 0
                minScore = currentMaxScore
            }
            stack[size++] = r
        }
    }
    writeInt(minScore)
    writeInt(size)
    writeByte(ASCII_n)
    while(size > 0) {
        writeInt(stack[--size])
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
    writeByte(ASCII_space)
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