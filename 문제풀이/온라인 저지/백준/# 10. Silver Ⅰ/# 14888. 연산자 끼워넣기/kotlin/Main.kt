var n = 0
lateinit var nums: IntArray
val oc = IntArray(4)
var min = Integer.MAX_VALUE
var max = Integer.MIN_VALUE

fun main() {
    n = i()
    nums = IntArray(n)
    for (i in nums.indices) nums[i] = i()
    for (i in oc.indices) oc[i] = i()
    back(0, nums[0])
    println(max)
    print(min)
}

private fun back(depth: Int, v: Int) {
    if (depth == n-1) {
        if (v > max) max = v
        if (v < min) min = v
        return
    }
    for (i in oc.indices) {
        if (oc[i] > 0) {
            oc[i] --
            when(i) {
                0 -> back(depth + 1, v + nums[depth +1])
                1 -> back(depth + 1, v - nums[depth +1])
                2 -> back(depth + 1, v * nums[depth +1])
                else -> back(depth + 1, v / nums[depth +1])
            }
            oc[i] ++
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
