fun main() {
    var m: Int
    var n: Int
    var parent = IntArray(0)
    var heap: Heap
    var saveCost: Int
    var cnt: Int
    var cur: Edge
    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a: Int, b: Int): Boolean {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot == bRoot) return false
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else parent[aRoot] = bRoot
        return true
    }
    while (true) {
        m = i()
        n = i()
        if (m == 0 && n == 0) {
            break
        }
        parent = IntArray(m) { it }
        heap = Heap(n)
        repeat(n) { heap.push(Edge(i(), i(), i())) }
        cnt = 0
        saveCost = 0
        while (heap.isNotEmpty()) {
            cur = heap.pop()
            if (cnt == m - 1) {
                saveCost += cur.cost
                continue
            }
            if (union(cur.from, cur.to)) {
                cnt++
            } else {
                saveCost += cur.cost
            }
        }
        writeInt(saveCost)
    }
    flushBuffer()
}

class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = this.cost - other.cost
}

class Heap(cap: Int) {
    private val arr = arrayOfNulls<Edge>(cap + 1)
    private var size = 0

    fun push(e: Edge) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i]!! < arr[p]!!) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = arr[1]!!
        arr[1] = arr[size]
        arr[size--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        while (true) {
            if (lt <= size && arr[lt]!! < arr[small]!!) small = lt
            if (rt <= size && arr[rt]!! < arr[small]!!) small = rt
            if (i == small) break
            arr[small] = arr[i].also { arr[i] = arr[small] }
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