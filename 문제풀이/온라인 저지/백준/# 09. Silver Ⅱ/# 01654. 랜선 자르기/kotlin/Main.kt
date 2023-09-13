fun main() {
    val k = i()
    val n = i()
    val arr = IntArray(k)
    var lt = 1L
    var rt = 0L
    for (i in 0 until k) {
        arr[i] = i()
        if (rt < arr[i]) rt = arr[i].toLong()
    }
    var answer = 0L
    var mid: Long
    var cnt: Long
    var success: Boolean
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        success = false
        cnt = 0
        for (ln in arr) {
            cnt += (ln / mid)
            if (cnt >= n) {
                success = true
                break
            }
        }
        if (success) {
            answer = mid
            lt = mid + 1
        } else {
            rt = mid - 1
        }
    }
    print(answer)
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
