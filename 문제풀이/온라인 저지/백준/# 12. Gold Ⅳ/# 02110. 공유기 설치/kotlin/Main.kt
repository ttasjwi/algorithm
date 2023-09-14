import java.util.*

fun main() {
    val n = i()
    val c = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    Arrays.sort(arr)
    var lt = 1
    var rt = arr[n-1] - arr[0]
    var mid: Int
    var cnt: Int
    var answer = 1
    var success : Boolean
    var before: Int
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        cnt = 0
        success = false
        before = arr[0] - mid
        for (e in arr) {
            if (e - before >= mid) {
                cnt ++
                before = e
            }
            if (cnt >= c) {
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