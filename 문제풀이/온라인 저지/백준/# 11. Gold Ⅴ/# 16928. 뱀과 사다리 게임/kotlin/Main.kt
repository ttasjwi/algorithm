fun main() {
    val c = 101
    val visit = BooleanArray(c)
    val warp = IntArray(c) { it }

    var n = i()
    var m = i()

    while (n-- > 0) warp[i()] = i()
    while (m-- > 0) warp[i()] = i()

    val q = IntArray(c)
    var f = 0
    var r = 1
    var s = 1
    q[1] = 1
    visit[1] = true
    var size: Int
    var cnt = -1
    var cur: Int
    var next: Int
    loop@while (s > 0) {
        cnt++
        size = s
        while (size-- > 0) {
            cur = q[((f + 1 + c)%c).also { f = it }]
            s --
            for (i in 1..6) {
                next = cur + i
                if (next == 100) {
                    cnt ++
                    break@loop
                }
                if (next >= c || visit[next]) continue
                visit[next] = true
                if (warp[next] != next) {
                    next = warp[next]
                    if (visit[next]) continue
                    visit[next] = true
                }
                q[((r+1+c)%c).also { r = it }] = next
                s ++
            }
        }
    }
    print(cnt)
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