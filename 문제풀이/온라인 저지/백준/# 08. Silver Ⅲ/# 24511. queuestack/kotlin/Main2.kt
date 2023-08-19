import java.util.LinkedList

fun main() {
    val n = i()

    val nums = IntArray(n)
    for (i in 0 until n) {
        nums[i] = if (i() == 1) -1 else 0
    }

    val q = LinkedList<Int>()
    for (i in 0 until n) {
        if (nums[i] < 0) {
            i()
        } else {
            nums[i] = i()
        }
    }

    for (i in n-1 downTo 0) {
        if (nums[i] > 0) {
            q.offer(nums[i])
        }
    }

    val m = i()
    var x: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        if (!q.isEmpty()) {
            q.offer(x)
            x = q.pop()
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