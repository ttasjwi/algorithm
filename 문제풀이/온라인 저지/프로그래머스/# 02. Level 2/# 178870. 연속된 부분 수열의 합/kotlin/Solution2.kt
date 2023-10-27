class Solution2 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var lt = 0
        var rt = 0
        val answer = IntArray(2)
        var minGap = -1
        var gap: Int
        var sum = sequence[0]
        while (lt <= rt && rt < sequence.size) {
            if (sum == k) {
                gap = rt - lt
                if (minGap == -1 || gap < minGap || (gap == minGap && lt < answer[0])) {
                    answer[0] = lt
                    answer[1] = rt
                    minGap = gap
                }
                sum -= sequence[lt++]
                if (rt != sequence.lastIndex) sum += sequence[++rt]
            } else if (sum > k) {
                sum -= sequence[lt++]
            } else {
                if (rt != sequence.lastIndex) sum += sequence[++rt]
                else break
            }
        }
        return answer
    }
}