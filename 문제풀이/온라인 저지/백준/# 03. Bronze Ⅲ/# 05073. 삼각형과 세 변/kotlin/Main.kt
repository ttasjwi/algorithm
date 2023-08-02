import java.util.*

fun main() {
    val nums = IntArray(3)

    val sb = StringBuilder()
    while (true) {
        nums[0] = readInt()
        nums[1] = readInt()
        nums[2] = readInt()

        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
            break
        }
        Arrays.sort(nums)
        sb.append(
            when {
                nums[0] == nums[2] -> "Equilateral\n"
                nums[2] >= nums[0] + nums[1] -> "Invalid\n"
                nums[0] == nums[1] || nums[1] == nums[2] -> "Isosceles\n"
                else -> "Scalene\n"
            }
        )
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}
