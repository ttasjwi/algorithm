import java.lang.StringBuilder

fun main() {
    val nums = IntArray(readInt())
    for (i in nums.indices) {
        nums[i] = readInt()
    }
    var min: Int
    var minIdx: Int
    for (i in 0 until nums.size) {
        min = nums[i]
        minIdx = i
        for (j in i + 1 until nums.size) {
            if (min > nums[j]) {
                min = nums[j]
                minIdx = j
            }
        }
        nums[minIdx] = nums[i]
        nums[i] = min
    }
    val sb = StringBuilder()
    for (i in nums.indices) {
        sb.append(nums[i]).append('\n')
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