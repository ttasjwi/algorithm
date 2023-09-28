fun main() {
    val n = i()
    if (n == 1) {
        print(0)
        return
    }
    val graph = Array(n+1) {ArrayList<IntArray>()}

    var a: Int
    var b: Int
    var c: Int
    for (i in 0 until n-1) {
        a = i()
        b = i()
        c = i()
        graph[a].add(intArrayOf(b, c))
        graph[b].add(intArrayOf(a, c))
    }
    var maxDistance = 0
    var maxNode = -1
    fun dfs(start: Int) {
        val st = arrayOfNulls<IntArray>(n-1)
        val check = BooleanArray(n+1)
        var size = 0
        check[start] = true
        st[size ++] = intArrayOf(start, 0)
        var cur: IntArray
        while (size > 0) {
            cur = st[--size]!!
            st[size] = null
            if (cur[1] > maxDistance) {
                maxDistance = cur[1]
                maxNode = cur[0]
            }
            for (next in graph[cur[0]]) {
                if (!check[next[0]]) {
                    check[next[0]] = true
                    st[size ++] = intArrayOf(next[0], cur[1] + next[1])
                }
            }
        }
    }
    dfs(1)
    maxDistance = 0
    dfs(maxNode)
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
