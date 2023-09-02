fun main() {
    val n = i()
    val a = Array(n) { Line(i(), i()) }
    val lis = IntArray(n)
    a.sort()

    lis[0] = a[0].to
    var rt = 0
    var l: Int
    var r: Int
    var m: Int
    var idx: Int

    loop@for (i in 1..a.lastIndex) {
        when  {
            lis[rt] < a[i].to -> lis[++rt] = a[i].to
            lis[rt] == a[i].to -> continue
            else -> {
                l = 0
                r = rt
                idx = r
                while (l <= r) {
                    m = (l + r)/2
                    when {
                        lis[m] == a[i].to -> continue@loop
                        lis[m] < a[i].to -> { l = m + 1 }
                        else -> {
                            idx = m
                            r = m - 1
                        }
                    }
                }
                lis[idx] = a[i].to
            }
        }
    }
    print(a.size - (rt+1))
}

data class Line(val from:Int, val to: Int) :Comparable<Line> {

    override fun compareTo(other: Line): Int {
        return from - other.from
    }
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s(): String {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}