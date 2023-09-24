fun main() {
    val n = i()
    val st = Stack(n)
    val graph = Array(n + 1) { ArrayList<Int>() }
    val parents = IntArray(n + 1) { -1 }

    var a: Int
    var b: Int
    for (i in 1..n-1) {
        a = i()
        b = i()
        graph[a].add(b)
        graph[b].add(a)
    }
    parents[1] = 0
    st.push(1)
    var cur: Int
    while (st.isNotEmpty()) {
        cur = st.pop()
        for (next in graph[cur]) {
            if (parents[next] >= 0) continue
            parents[next] = cur
            st.push(next)
        }
    }
    val sb = StringBuilder()
    for (i in 2..n) {
        sb.append(parents[i]).append('\n')
    }
    print(sb)
}

class Stack(cap: Int) {
    var p = 0
    val st = IntArray(cap)
    fun push(e: Int) {
        st[p++] = e
    }
    fun pop() = st[--p]
    fun isNotEmpty() = p != 0
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