fun main() {
    val n = i()
    val m = i()
    val arr = IntArray(n)
    var lt = 0
    var rt = 0
    for (i in 0 until n) {
        arr[i] = i()
        if (rt < arr[i]) rt = arr[i]
    }
    var answer = 0
    var mid: Int
    var sum: Long
    var success: Boolean
    var tmp: Int
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        sum = 0L
        success = false
        for (e in arr) {
            tmp = e - mid
            sum += if (tmp > 0) tmp else 0
            if (sum >= m) {
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