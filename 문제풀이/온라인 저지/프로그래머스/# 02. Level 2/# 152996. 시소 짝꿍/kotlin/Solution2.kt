class Solution {

    val rates = doubleArrayOf(4.0/3.0, 3.0/2.0, 2.0, 3.0/4.0, 2.0/3.0, 0.5, 1.0)

    fun solution(weights: IntArray): Long {
        val counter = HashMap<Double, Int>()

        var answer = 0L
        var v = 0.0
        for (weight in weights) {
            for (rate in rates) {
                v = weight * rate
                if (counter.containsKey(v)) {
                    answer += counter[v]!!
                }
            }
            if (counter.containsKey(v)) {
                counter[v] = counter[v]!! + 1
            } else {
                counter[v] = 1
            }
        }
        return answer
    }
}
