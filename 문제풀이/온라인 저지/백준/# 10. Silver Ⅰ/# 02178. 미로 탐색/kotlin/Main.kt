fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)

    val mr = i()
    val mc = i()
    val c = mr * mc + 1
    val q = arrayOfNulls<IntArray>(c)
    val flag = Array(mr) { BooleanArray(mc) }
    for (i in 0 until mr) {
        for (j in 0 until mc) {
            flag[i][j] = r() >= 49
        }
        r()
    }
    var f = 0
    var r = 1
    var s = 1
    flag[0][0] = false
    q[1] = intArrayOf(0, 0)

    var size: Int
    var cur: IntArray
    var nr: Int
    var nc: Int
    var depth = 0
    loop@ while (s > 0) {
        size = s
        depth += 1
        while (size-- > 0) {
            cur = q[((f + 1 + c) % c).also { f = it }]!!
            q[f] = null
            s--
            for (i in 0..3) {
                nr = cur[0] + dr[i]
                nc = cur[1] + dc[i]
                if (nr == mr - 1 && nc == mc - 1) {
                    depth += 1
                    break@loop
                }
                if ((nr in 0 until mr) && (nc in 0 until mc) && flag[nr][nc]) {
                    q[((r+1+c)%c).also { r = it }] = intArrayOf(nr, nc)
                    s++
                    flag[nr][nc] = false
                }
            }
        }
    }
    print(depth)
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
