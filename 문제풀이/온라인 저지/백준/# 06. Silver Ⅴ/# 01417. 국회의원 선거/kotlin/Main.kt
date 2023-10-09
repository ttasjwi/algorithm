fun main() {
    var n = i() - 1
    val dasom = i()
    var cnt = 0
    val heap = Heap(n)
    while (n-- > 0) heap.push(i())
    var cur: Int
    while (heap.isNotEmpty()) {
        cur = heap.pop()
        if (cur < dasom + cnt) break
        heap.push(cur - 1)
        cnt ++
    }
    writeInt(cnt)
    flushBuffer()
}

class Heap(cap: Int) {

    private val arr = IntArray(cap + 1)
    private var size = 0

    fun push(e: Int) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i] > arr[p]) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Int {
        val e = arr[1]
        arr[1] = arr[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while (true) {
            if (lt <= size && arr[lt] > arr[big]) big = lt
            if (rt <= size && arr[rt] > arr[big]) big = rt
            if (i == big) break
            arr[i] = arr[big].also { arr[big] = arr[i] }
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}


private const val EOF = -1
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(203)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(5)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(5)

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
