import java.util.*

fun main() {
    val n = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    val x = i()
    Arrays.sort(arr)
    var lt = 0
    var rt = n-1
    var sum: Int
    var cnt = 0
    while (lt < rt) {
        sum = arr[lt] + arr[rt]
        if (sum > x) {
            rt --
        } else if (sum < x) {
            lt ++
        } else {
            cnt ++
            lt ++
            rt --
        }
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