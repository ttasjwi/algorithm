class Solution {
    fun solution(topping: IntArray): Int {
        val counterA = HashMap<Int, Int>()
        val counterB = HashMap<Int, Int>()
        var answer = 0
        for (item in topping) {
            if (counterA.containsKey(item)) {
                counterA[item] = counterA[item]!! + 1
            } else {
                counterA[item] = 1
            }
        }
        for (item in topping) {
            counterA[item] = counterA[item]!! - 1
            if (counterA[item] == 0) counterA.remove(item)
            if (counterB.containsKey(item)) {
                counterB[item] = counterB[item]!! + 1
            } else {
                counterB[item] = 1
            }
            if (counterA.size == counterB.size) answer ++
        }
        return answer
    }
}
