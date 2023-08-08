import java.util.*

fun main() {
    val n = readInt()
    val original = IntArray(n)
    val sorted = IntArray(n)

    for (i in 0 until n) {
        original[i] = readInt()
        sorted[i] = original[i]
    }
    Arrays.sort(sorted)
    val map = HashMap<Int, Int>()
    var rank = -1
    for (i in sorted.indices) {
        if (!map.containsKey(sorted[i])) {
            map[sorted[i]] = ++ rank
        }
    }
    val sb = StringBuilder()
    for (num in original) {
        sb.append(map[num]).append(' ')
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}