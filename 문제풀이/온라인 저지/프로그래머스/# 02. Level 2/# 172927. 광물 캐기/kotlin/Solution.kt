class Solution {

    private val table = arrayOf(
        mapOf("diamond" to 1, "iron" to 1, "stone" to 1),
        mapOf("diamond" to 5, "iron" to 1, "stone" to 1),
        mapOf("diamond" to 25, "iron" to 5, "stone" to 1)
    )

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = Integer.MAX_VALUE
        fun dfs(startStem: Int, startIdx: Int) {
            if (startIdx == minerals.size || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
                if (answer > startStem) answer = startStem
                return
            }
            var c: Int
            var i: Int
            var stem: Int
            for (j in picks.indices) {
                if (picks[j] > 0) {
                    picks[j] --
                    c = 5
                    i = startIdx
                    stem = startStem
                    while (c-- > 0) {
                        stem += table[j][minerals[i]]!!
                        i ++
                        if (i == minerals.size) break
                    }
                    dfs(stem, i)
                    picks[j] ++
                }
            }
        }
        dfs(0, 0)
        return answer
    }

}
