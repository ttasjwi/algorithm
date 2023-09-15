fun main() {
    var n = i()
    val heap = IntArray(n+1)
    var size = 0
    fun insert(x: Int) {
        heap[++size] = x
        var i = size
        var p = i shr 1
        var diff: Int
        while (p > 0) {
            diff = Math.abs(heap[i]) - Math.abs(heap[p])
            if (diff < 0 || (diff == 0 && heap[i] < heap[p])) {
                heap[p] = heap[i].also { heap[i] = heap[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }
    fun extract() : Int {
        if (size == 0) return 0
        val e = heap[1]
        heap[1] = heap[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt +1
        var small = i
        var diff: Int
        while(true) {
            if (lt <= size) {
                diff = Math.abs(heap[lt]) - Math.abs(heap[small])
                if (diff < 0 || (diff == 0 && heap[lt] < heap[small])) {
                    small = lt
                }
            }
            if (rt <= size) {
                diff = Math.abs(heap[rt]) - Math.abs(heap[small])
                if (diff < 0 || (diff == 0 && heap[rt] < heap[small])) {
                    small = rt
                }
            }
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
            small = i
        }
        return e
    }
    var x: Int
    val sb = StringBuilder()
    while (n -- > 0) {
        x = i()
        if (x == 0) {
            sb.append(extract()).append('\n')
        } else {
            insert(x)
        }
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
    val n = c.toInt() == 45
    c = if (n) r() else c
    do { v = v * 10 + c - 48 } while (r().also { c = it } > 47)
    return if (n) -v else v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
