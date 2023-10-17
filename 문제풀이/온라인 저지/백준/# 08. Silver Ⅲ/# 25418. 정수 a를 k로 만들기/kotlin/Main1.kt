fun main() {
    val a = i()
    val k = i()
    val queue = Queue(k - a + 1)
    val check = BooleanArray(k - a + 1)
    var cur: Int
    queue.enQueue(a)

    var cost = -1
    var size: Int
    var next: Int
    check[0] = true
    loop@ while (queue.isNotEmpty()) {
        cost++
        size = queue.size
        while (size-- > 0) {
            cur = queue.deQueue()
            next = cur + 1
            if (next == k) {
                cost++
                break@loop
            } else if (next < k && !check[next - a]) {
                check[next - a] = true
                queue.enQueue(next)
            }
            next = cur * 2
            if (next == k) {
                cost++
                break@loop
            } else if (next < k && !check[next - a]) {
                check[next - a] = true
                queue.enQueue(next)
            }
        }
    }
    writeInt(cost)
    flushBuffer()
}

class Queue(cap: Int) {
    var size = 0
    private var f = 0
    private var r = 0
    private val c = cap + 1
    private val arr = IntArray(c)
    fun enQueue(e: Int) {
        size++
        arr[((r + 1 + c) % c).also { r = it }] = e
    }

    fun deQueue(): Int {
        size--
        return arr[((f + 1 + c) % c).also { f = it }]
    }

    fun isNotEmpty() = size != 0
}


private const val EOF = -1
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(16)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(14)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(14)

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
