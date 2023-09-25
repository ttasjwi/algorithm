fun main() {
    val n = i()
    var m = i()
    val parent = IntArray(n + 1) { it }
    val sb = StringBuilder()
    var o: Int
    var a: Int
    var b: Int

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        return find(parent[x]).also { parent[x] = it }
    }

    fun union(a: Int, b:Int) {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else if (aRoot > bRoot) parent[aRoot] = bRoot

    }

    while (m-- > 0) {
        o = i()
        a = i()
        b = i()

        if (o == 0) {
            union(a, b)
        } else {
            sb.append(if (find(a) == find(b)) "YES\n" else "NO\n")
        }
    }
    print(sb)
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