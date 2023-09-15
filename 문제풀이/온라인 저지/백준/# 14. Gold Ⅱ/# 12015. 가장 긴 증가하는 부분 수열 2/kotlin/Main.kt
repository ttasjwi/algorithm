fun main() {
    val n = i()
    var cur = i()
    var rt = 0
    val lis = IntArray(n)
    lis[0] = cur

    var l: Int
    var r: Int
    var mid: Int
    var tmp = 0
    loop@ for (i in 1 until n) {
        cur = i()
        when {
            lis[rt] == cur -> {
                continue
            }

            lis[rt] < cur -> {
                lis[++rt] = cur
            }

            else -> {
                l = 0
                r = rt
                while (l <= r) {
                    mid = (l + r) shr 1
                    if (lis[mid] == cur) {
                        continue@loop
                    } else if (lis[mid] > cur) {
                        tmp = mid
                        r = mid - 1
                    } else {
                        l = mid + 1
                    }
                }
                lis[tmp] = cur
            }
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