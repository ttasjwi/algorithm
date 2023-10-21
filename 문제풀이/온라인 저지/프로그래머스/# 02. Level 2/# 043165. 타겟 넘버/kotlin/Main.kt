class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(value: Int, idx: Int) {
            if (idx == numbers.size) {
                if (value == target) answer ++
                return
            }
            dfs(value + numbers[idx], idx + 1)
            dfs(value - numbers[idx], idx + 1)
        }
        dfs(0, 0)
        return answer
    }
}
