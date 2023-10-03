fun main() {
    val n = i()
    val m = i()
    val k = i()
    val x = i()

    val inf = 1_000_000
    val heap = Heap(m)
    val check = BooleanArray(n+1)
    val cost = IntArray(n+1) { inf }
    val graph = Array(n+1) {ArrayList<Int>()}
    for (i in 0 until m) {
        graph[i()] += i()
    }
    cost[x] = 0
    heap.push(Edge(x, 0))

    var cur: Edge
    var alt: Int
    var find = false
    while(heap.isNotEmpty()) {
        cur = heap.pop()
        if (check[cur.to]) continue
        if (cur.cost > k) break
        else if (cur.cost == k) {
            if (!find) find = true
            writeInt(cur.to)
            writeN()
        }
        check[cur.to] = true
        for (next in graph[cur.to]) {
            alt = cur.cost + 1
            if (cost[next] > alt) {
                cost[next] = alt
                heap.push(Edge(next, alt))
            }
        }
    }
    if (!find) {
        writeInt(-1)
    }
    flushBuffer()
}

data class Edge(val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) =  (cost - other.cost).let { if (it == 0) to - other.to else it}
}

class Heap(cap: Int) {

    private var size = 0
    private var heap = arrayOfNulls<Edge>(cap + 1)

    fun push(e: Edge) {
        heap[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (heap[i]!! < heap[p]!!) {
                heap[i] = heap[p].also { heap[p] = heap[i] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = heap[1]!!
        heap[1] = heap[size]
        heap[size--] = null

        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i

        while (true) {
            if (lt <= size && heap[lt]!! < heap[small]!!) small = lt
            if (rt <= size && heap[rt]!! < heap[small]!!) small = rt
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
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
}

private fun writeByte(b: Byte) {
    if (outbufferpointer == outbuffer.size) flushBuffer()
    outbuffer[outbufferpointer++] = b
}

private fun writeN() {
    writeByte(ASCII_n)
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        dout.write(outbuffer, 0, outbufferpointer)
        outbufferpointer = 0
    }
}

private fun isDigit(b: Byte) = b >= ASCII_0