class Solution {
    val rates = arrayOf(intArrayOf(4,3), intArrayOf(3,2), intArrayOf(2,1))

    fun solution(weights: IntArray): Long {
        var answer = 0L
        var max: Int
        var min: Int
        for (lt in weights.indices) {
            for (rt in lt+1..weights.lastIndex) {
                if (weights[lt] == weights[rt]) answer ++
                else {
                    if (weights[lt] > weights[rt]) {
                        max = weights[lt]
                        min = weights[rt]
                    } else {
                        max = weights[rt]
                        min = weights[lt]
                    }
                    for (rate in rates) {
                        if (rate[0] * min == rate[1] * max) {
                            answer ++
                            break
                        }
                        else if (rate[0] * min > rate[1] * max) break
                    }
                }
            }
        }
        return answer
    }
}