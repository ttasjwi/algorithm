class Solution1 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val sum = IntArray(sequence.size)
        sum[0] = sequence[0]
        for (i in 1..sequence.lastIndex) {
            sum[i] = sum[i-1] + sequence[i]
        }
        var minGap = -1
        val answer = IntArray(2)
        for (start in sum.indices) {
            var lt = start
            var rt = sum.lastIndex
            var end = -1
            while (lt <= rt) {
                val mid = (lt + rt) shr 1
                val currentSum = if (start == 0) sum[mid] else sum[mid] - sum[start - 1]
                if (currentSum == k) {
                    end = mid
                    break
                } else if (currentSum > k) {
                    rt = mid - 1
                } else {
                    lt = mid + 1
                }
            }
            if (end !== -1) {
                val gap = end - start
                if (minGap == -1 || gap < minGap || (gap == minGap && start < answer[0])) {
                    answer[0] = start
                    answer[1] = end
                    minGap = gap
                }
            }
        }
        return answer
    }
}