fun main() {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var t = i()

    var mx: Int
    var my: Int
    var k: Int
    var st: Array<IntArray?>
    var cabbage: Array<BooleanArray>
    var p = -1

    val sb = StringBuilder()
    var cnt:Int
    var cur: IntArray
    var nx:Int
    var ny:Int
    while (t-- > 0) {
        mx = i()
        my = i()
        k = i()
        st = arrayOfNulls(mx * my)
        cabbage = Array(mx) { BooleanArray(my) }

        while (k-- > 0) cabbage[i()][i()] = true
        cnt = 0
        for (i in 0 until mx) {
            for (j in 0 until my) {
                if (!cabbage[i][j]) continue
                cnt += 1
                cabbage[i][j] = false
                st[++p] = intArrayOf(i,j)
                while (p >=0) {
                    cur = st[p]!!.also { st[p--] = null }
                    for (a in 0..3) {
                        nx = cur[0] + dx[a]
                        ny = cur[1] + dy[a]
                        if ((nx in 0 until mx) && (ny in 0 until my) && cabbage[nx][ny]) {
                            cabbage[nx][ny] = false
                            st[++p] = intArrayOf(nx, ny)
                        }
                    }
                }
            }
        }
        sb.append(cnt).append('\n')
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
