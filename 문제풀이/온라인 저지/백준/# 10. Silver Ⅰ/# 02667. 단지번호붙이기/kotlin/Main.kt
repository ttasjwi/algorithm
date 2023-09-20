import java.util.*

fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)

    val n = i()
    val house = Array(n){BooleanArray(n)}
    for (i in 0 until n) {
        for (j in 0 until n ) {
            house[i][j] = r() >= 49
        }
        r()
    }

    val st = arrayOfNulls<IntArray>(n*n)
    var p = -1

    var cur: IntArray
    var nr: Int
    var nc: Int
    var cnt: Int
    val counts = ArrayList<Int>()
    for (i in 0..n-1) {
        for (j in 0..n-1) {
            if (!house[i][j]) continue
            cnt = 1
            st[++p] = intArrayOf(i,j)
            house[i][j] = false
            while (p >= 0) {
                cur = st[p]!!.also { st[p--] = null }
                for (k in 0..3) {
                    nr = cur[0] + dr[k]
                    nc = cur[1] + dc[k]
                    if ((0<=nr && nr <n) && (0 <= nc && nc < n) && house[nr][nc]) {
                        house[nr][nc] = false
                        st[++p] = intArrayOf(nr, nc)
                        cnt ++
                    }
                }
            }
            counts.add(cnt)
        }
    }
    Collections.sort(counts)
    val sb = StringBuilder()
    sb.append(counts.size).append('\n')
    for (x in counts) {
        sb.append(x).append('\n')
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