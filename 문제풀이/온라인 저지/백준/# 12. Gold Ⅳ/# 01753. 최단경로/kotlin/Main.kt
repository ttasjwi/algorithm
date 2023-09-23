fun main() {
    val v = i()
    val e = i()
    val inf = 3_000_001
    val graph = Array(v + 1) { ArrayList<IntArray>() }
    val start = i()
    for (i in 0 until e) {
        graph[i()] += intArrayOf(i(), i())
    }
    val heap = Heap(e)
    val check = BooleanArray(v+1)
    val costs = IntArray(v + 1) { inf }
    heap.push(intArrayOf(start, 0))
    costs[start] = 0
    var cur: IntArray
    var alt: Int
    while (heap.s != 0) {
        cur = heap.pop()
        if (check[cur[0]]) continue
        check[cur[0]] = true
        for (next in graph[cur[0]]) {
            alt = cur[1] + next[1]
            if (costs[next[0]] < alt) continue
            costs[next[0]] = alt
            heap.push(intArrayOf(next[0], alt))
        }
    }
    val sb = StringBuilder()
    for (x in 1..v) {
        sb.append(if (costs[x] == inf) "INF" else costs[x]).append('\n')
    }
    print(sb)
}

class Heap(c: Int) {
    val heap = arrayOfNulls<IntArray>(c + 1)
    var s = 0

    fun pop() : IntArray {
        val e = heap[1]!!
        heap[1] = heap[s]
        heap[s--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        while (true) {
            if (lt <= s && heap[lt]!![1] < heap[small]!![1]) small = lt
            if (rt <= s && heap[rt]!![1] < heap[small]!![1]) small = rt
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
            small = i
        }
        return e
    }

    fun push(e: IntArray) {
        heap[++s] = e
        var i = s
        var p = i shr 1
        while (p > 0) {
            if (heap[p]!![1] > heap[i]!![1]) {
                heap[i] = heap[p].also { heap[p] = heap[i] }
                i = p
                p = i shr 1
            } else {
                break
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
