fun main() {
    val n = i()
    val e = i()
    val parent = IntArray(n + 1) { it }
    val heap = Heap(e)
    repeat(e) { heap.push(Edge(i(), i(), i())) }

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

    var cnt = 0
    var costSum = 0

    var edge: Edge
    while (heap.size > 0) {
        edge = heap.pop()
        if (union(edge.from, edge.to)) {
            cnt++
            costSum += edge.cost
            if (cnt == n - 1) {
                break
            }
        }
    }
    print(costSum)
}

data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {

    override fun compareTo(other: Edge): Int = this.cost - other.cost
}


class Heap(capacity: Int) {
    private val edges = arrayOfNulls<Edge>(capacity + 1)
    var size = 0

    fun push(e: Edge) {
        edges[++size] = e
        var i = size
        var p = i shr 1
        var tmp: Edge
        while (p > 0) {
            if (edges[i]!! < edges[p]!!) {
                tmp = edges[i]!!
                edges[i] = edges[p]
                edges[p] = tmp
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = edges[1]!!
        edges[1] = edges[size]
        edges[size--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        var tmp: Edge
        while (true) {
            if (lt <= size && edges[lt]!! < edges[small]!!) small = lt
            if (rt <= size && edges[rt]!! < edges[small]!!) small = rt
            if (small == i) break
            tmp = edges[i]!!
            edges[i] = edges[small]
            edges[small] = tmp
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}