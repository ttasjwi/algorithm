class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val costs = HashMap<Char, Int>()
        for (str in keymap) {
            for (i in str.indices) {
                if (!costs.containsKey(str[i])) {
                    costs[str[i]] = i+1
                } else {
                    costs[str[i]] = minOf(costs[str[i]]!!, i+1)
                }
            }
        }
        val answer = IntArray(targets.size)
        for (i in targets.indices) {
            for (j in targets[i].indices) {
                if (costs.containsKey(targets[i][j])) {
                    answer[i] += costs[targets[i][j]]!!
                } else {
                    answer[i] = -1
                    break
                }
            }
        }
        return answer
    }
}