fun main() {
    val n = i()
    val m = i()
    val v = i()
    val g = Array(n + 1) { ArrayList<Int>() }
    val dq = DQ(m)
    val check = BooleanArray(n + 1)
    val sb = StringBuilder()

    var a: Int
    var b: Int
    for (i in 1..m) {
        a = i()
        b = i()
        g[a].add(b)
        g[b].add(a)
    }
    for (i in 1..n) g[i].sort()

    dq.eq(v)
    var x: Int
    while (dq.isNotEmpty()) {
        x = dq.dqLast()
        if (check[x]) continue
        check[x] = true
        sb.append(x).append(' ')
        for (i in g[x].size - 1 downTo 0) {
            if (check[g[x][i]]) continue
            dq.eq(g[x][i])
        }
    }
    sb.append('\n')

    for (i in 1..n) check[i] = false

    dq.eq(v)
    check[v] = true
    sb.append(v).append(' ')
    while (dq.isNotEmpty()) {
        x = dq.dq()
        for (next in g[x]) {
            if (check[next]) continue
            dq.eq(next)
            check[next] = true
            sb.append(next).append(' ')
        }
    }
    sb.append('\n')
    print(sb)
}

class DQ(cap: Int) {
    var f = 0
    var r = 0
    var s = 0
    val c = cap + 1
    val arr = IntArray(c + 1)
    fun eq(e: Int) {
        arr[((r + 1 + c) % c).also { r = it }] = e
        s++
    }
    fun dqLast() = arr[r.also { r = (it - 1 + c) % c; s-- }]
    fun dq() = arr[((f + 1 + c) % c).also { f = it; s-- }]
    fun isNotEmpty() = s > 0
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
