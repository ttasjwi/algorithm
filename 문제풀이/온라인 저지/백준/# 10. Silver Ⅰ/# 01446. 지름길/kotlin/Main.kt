fun main() {
    val n = i()
    val d = i()
    val inf = 10001
    val dp = IntArray(d+1) {inf}
    dp[0] = 0
    val graph = HashMap<Int, ArrayList<IntArray>>()

    var from: Int
    var to: Int
    var cost: Int
    for (i in 0 until n) {
        from = i()
        to = i()
        cost = i()
        if (to > d) continue
        if (!graph.containsKey(from)) {
            graph[from] = ArrayList()
        }
        graph[from]!!.add(intArrayOf(to, cost))
    }

    var alt: Int
    for (i in 0 until d) {
        if (dp[i+1] > dp[i] + 1) {
            dp[i+1] = dp[i] + 1
        }
        if (graph.containsKey(i)) {
            for (edge in graph[i]!!) {
                alt = dp[i] + edge[1]
                if (dp[edge[0]] > alt) {
                    dp[edge[0]] = alt
                }
            }
        }
    }
    writeInt(dp[d])
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
