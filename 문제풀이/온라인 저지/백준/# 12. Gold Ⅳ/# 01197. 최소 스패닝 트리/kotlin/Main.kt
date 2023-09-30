import java.util.*

fun main() {
    val v = i()
    val e = i()
    val parent = IntArray(v + 1) { it }
    val edges = arrayOfNulls<Edge>(e)
    for (i in 0 until e) {
        edges[i] = Edge(i(), i(), i())
    }
    Arrays.sort(edges)

    fun find(x: Int): Int {
        if (parent[x] == x) {
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a:Int, b:Int) {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else if (aRoot > bRoot) parent[aRoot] = bRoot
    }
    var totalCost = 0
    var cnt = 0
    for (edge in edges) {
        if (find(edge!!.from) != find(edge.to)) {
            union(edge.from, edge.to)
            totalCost += edge.cost
            cnt ++
            if (cnt == v-1) break
        }
    }
    print(totalCost)
}


data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int = cost - other.cost
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    val n = c.toInt() == 45
    c = if (n) r() else c
    do {
        v = v * 10 + c - 48
    } while (r().also { c = it } > 47)
    return if (n) -v else v
}


private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}