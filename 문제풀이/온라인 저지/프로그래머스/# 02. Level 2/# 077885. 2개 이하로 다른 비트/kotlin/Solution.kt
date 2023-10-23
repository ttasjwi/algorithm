import java.util.*

class Solution {
    fun solution(numbers: LongArray): LongArray {
        fun f(x: Long): Long {
            if (x % 2 == 0L) return x + 1
            val chars = x.toString(2).toCharArray()
            val index = chars.lastIndexOf('0')
            if (index == -1) return (1L shl chars.size) or (x shr 1)
            chars[index] = '1'
            chars[index+1] = '0'
            return String(chars).toLong(2)
        }
        for (i in numbers.indices) {
            numbers[i] = f(numbers[i])
        }
        return numbers
    }

}