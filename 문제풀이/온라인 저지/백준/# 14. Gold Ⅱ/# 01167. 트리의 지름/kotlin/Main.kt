fun main() {
    val v = i()
    val graph = Array(v+1) {ArrayList<IntArray>()}
    var from: Int
    var to: Int
    var cost: Int
    for (i in 0 until v) {
        from = i()
        while(true) {
            to = i()
            if (to == -1) break
            cost = i()
            graph[from].add(intArrayOf(to, cost))
        }
    }

    var maxDistance = 0
    var maxNode = -1
    fun dfs(start: Int) {
        val check = BooleanArray(v+1)
        val st = arrayOfNulls<IntArray>(v)
        var size = 1
        st[0] = intArrayOf(start, 0)
        check[start] = true
        var cur: IntArray
        while (size > 0) {
            cur = st[--size]!!
            if (cur[1] > maxDistance) {
                maxNode = cur[0]
                maxDistance = cur[1]
            }
            for (next in graph[cur[0]]) {
                if (!check[next[0]]) {
                    check[next[0]] = true
                    st[size++] = intArrayOf(next[0], cur[1] + next[1])
                }
            }
        }
    }
    dfs(1)
    dfs(maxNode.also{maxNode = -1; maxDistance = 0})
    println(maxDistance)
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
    do { v = v * 10 + c - 48 } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}