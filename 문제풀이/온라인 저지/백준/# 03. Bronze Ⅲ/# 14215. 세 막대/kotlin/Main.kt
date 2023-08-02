import java.util.*

fun main() {
    val nums = IntArray(3)
    nums[0] = readInt()
    nums[1] = readInt()
    nums[2] = readInt()
    Arrays.sort(nums)

    print(nums[0] + nums[1] + if (nums[2] < nums[0] + nums[1]) nums[2] else nums[0] + nums[1] - 1)
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}