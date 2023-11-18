class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int
        if (num_list.size <= 10) {
            answer = 1
            for (num in num_list) {
                answer *= num
            }
        } else {
            answer = 0
            for (num in num_list) {
                answer += num
            }
        }
        return answer
    }
}
