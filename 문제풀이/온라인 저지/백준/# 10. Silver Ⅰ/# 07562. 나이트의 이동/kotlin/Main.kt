val dr = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)
val dc = intArrayOf(2, 2, 1, -1, -2, -2, 1, -1)
val sb = StringBuilder()

fun main() {
    var t = i()
    while (t-- > 0) {
        bfs(i(), i(), i(), i(), i())
    }
    print(sb)
}

class Point(val r: Int, val c: Int)

class Queue(cap: Int) {
    val c = cap + 1
    val q = arrayOfNulls<Point>(c)
    var f = 0
    var r = 0
    var s = 0

    fun eq(e: Point) {
        s++
        q[((r + 1 + c) % c).also { r = it }] = e
    }

    fun dq(): Point {
        s--
        return q[((f + 1 + c) % c).also { f = it }]!!
    }
    fun isEmpty() = s == 0
}

fun bfs(l: Int, sr: Int, sc: Int, tr: Int, tc: Int) {
    if (sr == tr && sc == tc) {
        sb.append('0').append('\n')
        return
    }
    val board = Array(l) {BooleanArray(l)}
    val q = Queue(l * l)
    var cur: Point
    var size: Int
    var nr: Int
    var nc: Int
    q.eq(Point(sr, sc))
    board[sr][sc] = true
    var cnt = -1
    while (!q.isEmpty()) {
        cnt++
        size = q.s
        while (size-- > 0) {
            cur = q.dq()
            for (i in 0..7) {
                nr = cur.r + dr[i]
                nc = cur.c + dc[i]
                if (tr == nr && tc == nc) {
                    sb.append(cnt+1).append('\n')
                    return
                }
                if ((nr in 0 until l) && (nc in 0 until l) && !board[nr][nc]) {
                    board[nr][nc] = true
                    q.eq(Point(nr, nc))
                }
            }
        }
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
