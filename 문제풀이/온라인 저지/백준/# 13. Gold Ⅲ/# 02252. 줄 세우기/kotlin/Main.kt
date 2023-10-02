fun main() {
    val n = i()
    val m = i()

    val graph = Array(n + 1) { ArrayList<Int>() }
    val inDegree = IntArray(n + 1)

    var from: Int
    var to: Int

    repeat(m) {
        from = i()
        to = i()
        graph[from].add(to)
        inDegree[to]++
    }

    val st = IntArray(n)
    var size = 0
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            st[size++] = i
            ws(i)
        }
    }

    var cur: Int
    while (size > 0) {
        cur = st[--size]
        for (next in graph[cur]) {
            inDegree[next]--
            if (inDegree[next] == 0) {
                st[size++] = next
                ws(next)
            }
        }
    }
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
    try {
        bytesread = din.read(inbuffer, 0.also { inbufferpointer = it }, inbuffer.size)
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

private fun ws(i: Int) {
    var i = i
    if (i == 0) {
        w(ASCII_0)
    } else {
        if (i < 0) {
            w(ASCII_minus)
            i = -i
        }
        var index = 0
        while (i > 0) {
            bytebuffer[index++] = (i % 10 + ASCII_0).toByte()
            i /= 10
        }
        while (index-- > 0) {
            w(bytebuffer[index])
        }
    }
    w(ASCII_space)
}

private fun w(b: Byte) {
    if (outbufferpointer == outbuffer.size) flushBuffer()
    outbuffer[outbufferpointer++] = b
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        try {
            dout.write(outbuffer, 0, outbufferpointer)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        outbufferpointer = 0
    }
}

private fun isDigit(b: Byte) = b >= ASCII_0
