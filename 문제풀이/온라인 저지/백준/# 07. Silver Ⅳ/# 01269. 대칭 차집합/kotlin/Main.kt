fun main() {
    var na = i()
    var nb = i()

    val set = HashSet<Int>()
    var cnt = 0
    while (na --> 0) {
        set.add(i())
        cnt ++
    }
    var tmp: Int
    while (nb --> 0) {
        tmp = i()
        if (set.contains(tmp)) cnt -- else cnt ++
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
