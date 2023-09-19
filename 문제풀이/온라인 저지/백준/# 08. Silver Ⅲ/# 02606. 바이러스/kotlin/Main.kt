fun main() {
    val n = i()
    val check = BooleanArray(n+1)
    val graph = Array(n+1) {ArrayList<Int>()}

    var m = i()
    val c = m+1
    val q = IntArray(c)
    var f = 0
    var r = 0
    var s = 0
    var a:Int
    var b:Int
    while (m -- > 0) {
        a = i()
        b = i()
        graph[a].add(b)
        graph[b].add(a)
    }
    fun eq(e:Int) {
        q[((r+1+c)%c).also { r = it }] = e
        s ++
    }
    fun dq(): Int {
        s--
        return q[((f + 1 + c) % c).also { f = it }]
    }

    check[1] = true
    eq(1)
    var x: Int
    var answer = 0
    while (s != 0) {
        x = dq()
        for (next in graph[x]) {
            if (!check[next]) {
                check[next] = true
                answer ++
                eq(next)
            }
        }
    }
    print(answer)
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