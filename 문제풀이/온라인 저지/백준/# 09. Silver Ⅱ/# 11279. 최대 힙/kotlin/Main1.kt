fun main() {
    var n = i()
    val heap = Heap(n)
    val sb = StringBuilder()
    var tmp: Int
    while (n-- > 0) {
        tmp = i()
        if (tmp == 0) sb.append(heap.extract()).append('\n')
        else heap.insert(tmp)
    }
    print(sb)
}

class Heap(cap: Int) {

    private val items = IntArray(cap + 1)
    private var size = 0

    fun insert(e: Int) {
        items[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (items[i] > items[p]) {
                items[p] = items[i].also { items[i] = items[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun extract(): Int {
        if (size == 0) return 0
        val e = items[1]
        items[1] = items[size--]

        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i

        while (true) {
            if (lt <= size && items[lt] > items[big]) big = lt
            if (rt <= size && items[rt] > items[big]) big = rt

            if (big == i) break

            items[big] = items[i].also { items[i] = items[big] }
            i = big
            lt = i shl 1
            rt = lt + 1
            big = i
        }
        return e
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
