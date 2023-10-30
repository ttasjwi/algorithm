class Solution {
    fun solution(storey: Int): Int {
        var cur = storey
        var mod: Int
        var answer = 0
        while (cur > 0) {
            mod = cur % 10
            if (mod == 0) {
                cur /= 10
            } else if (mod == 5) {
                if ((cur / 10) % 10 < 5) {
                    answer += mod
                    cur /= 10
                } else {
                    answer += (10 - mod)
                    cur = cur / 10 + 1
                }
            } else if (mod <= 4) {
                answer += mod
                cur /= 10
            } else {
                answer += (10 - mod)
                cur = cur / 10 + 1
            }
        }
        return answer
    }
}
