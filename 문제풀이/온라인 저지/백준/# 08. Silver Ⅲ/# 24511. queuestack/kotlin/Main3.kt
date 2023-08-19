fun main() {
    val n = i()

    val nums = IntArray(n)
    for (i in 0 until n) if (i() == 1) nums[i] = -1
    for (i in 0 until n) if (nums[i] < 0) i() else nums[i] = i()

    val c = 100_001
    val qStack = IntArray(c)
    var r = 0
    for (i in n-1 downTo 0) if (nums[i] > 0) qStack[++r] = nums[i]

    var f = 0
    val s = r-f

    val m = i()
    var x: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        if (s != 0) {
            r = (r+1+c)%c
            qStack[r] = x

            f = (f+1+c)%c
            x = qStack[f]
        }
        sb.append(x).append(' ')
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