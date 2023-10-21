class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val check = BooleanArray(dungeons.size)
        fun backTracking(l: Int, cnt: Int) {
            var isEnd = true
            for (i in dungeons.indices) {
                if (l >= dungeons[i][0] && !check[i]) {
                    if (isEnd) {
                        isEnd = false
                    }
                    check[i] = true
                    backTracking(l - dungeons[i][1], cnt + 1)
                    check[i] = false
                }
            }
            if (isEnd && cnt > answer) {
                answer = cnt
            }
        }
        backTracking(k, 0)
        return answer
    }
}
