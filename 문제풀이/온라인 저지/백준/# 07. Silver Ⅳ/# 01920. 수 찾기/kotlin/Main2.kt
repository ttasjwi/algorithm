import java.util.Arrays

fun main() {
    val n = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
       arr[i] = i()
    }
    Arrays.sort(arr)

    var m = i()
    val sb = StringBuilder()

    fun bin(t: Int) {
        var lt = 0
        var rt = n-1
        var mid: Int

        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                sb.append(1).append('\n')
                return
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        sb.append(0).append('\n')
    }

    while (m -- > 0) {
        bin(i())
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