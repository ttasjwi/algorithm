class Solution {
    fun solution(num_str: String): Int {
        var answer = 0
        for (ch in num_str) {
            answer += (ch.code - 48)
        }
        return answer
    }
}
