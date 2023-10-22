class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = IntArray(numbers.size)
        val result = IntArray(numbers.size)
        var size = 0
        for (i in numbers.indices) {
            while(size > 0) {
                if (numbers[stack[size-1]] < numbers[i]) {
                    result[stack[size-1]] = numbers[i]
                    size --
                } else {
                    break
                }
            }
            stack[size++] = i
        }
        while (size > 0) {
            result[stack[size-1]] = -1
            size --
        }
        return result
    }
}
