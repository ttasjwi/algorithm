fun main() {
    val n = i()
    val a = IntArray(n)
    val lis = IntArray(n)
    for (i in a.indices) a[i] = i()

    lis[0] = a[0]
    var rt = 0

    var l: Int
    var r: Int
    var m: Int
    var idx: Int

    loop@for (i in 1..n-1) {
        if (lis[rt] < a[i]) {
            lis[++rt] = a[i]
        } else if (lis[rt] == a[i]) {
            continue
        } else {
            l = 0
            r = rt
            idx = r
            while (l <= r) {
                m = (l + r)/2
                if (lis[m] == a[i]) continue@loop
                else if (lis[m] < a[i]) {
                    l = m + 1
                } else {
                    idx = m
                    r = m - 1
                }
            }
            lis[idx] = a[i]
        }
    }
    print(++rt)
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
