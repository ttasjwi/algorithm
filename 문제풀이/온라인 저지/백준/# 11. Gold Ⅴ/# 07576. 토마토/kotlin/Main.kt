fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)
    val mc = i()
    val mr = i()
    val board = Array(mr) { BooleanArray(mc) }
    val c = mc * mr + 1
    val q = arrayOfNulls<IntArray>(c)
    var notRipe = 0
    var f = 0
    var r = 0
    var s = 0
    for (i in 0 until mr) {
        for (j in 0 until mc) {
            i().also {
                when (it) {
                    0 -> {
                        notRipe++
                    }

                    1 -> {
                        board[i][j] = true
                        q[((r + 1 + c) % c).also { r = it }] = intArrayOf(i, j)
                        s++
                    }

                    else -> {
                        board[i][j] = true
                    }
                }
            }
        }
    }
    if (notRipe == 0 && s > 0) {
        print(0)
        return
    }
    var cur: IntArray
    var size: Int
    var day = -1
    var nr: Int
    var nc: Int
    while (s > 0) {
        day ++
        size = s
        while (size-- > 0) {
            cur = q[((f + 1 + c) % c).also { f = it }]!!
            s--
            for (i in 0..3) {
                nr = cur[0] + dr[i]
                nc = cur[1] + dc[i]
                if ((nr in 0 until mr) && (nc in 0 until mc) && !board[nr][nc]) {
                    board[nr][nc] = true
                    notRipe --
                    q[((r + 1 + c) % c).also { r = it }] = intArrayOf(nr, nc)
                    s++
                }
            }
        }
    }
    print(if (notRipe > 0) -1 else day)
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