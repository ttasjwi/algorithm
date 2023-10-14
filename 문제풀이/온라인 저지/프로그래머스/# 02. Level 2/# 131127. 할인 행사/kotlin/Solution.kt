class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wantCounter = HashMap<String, Int>()
        val counter = HashMap<String, Int>()
        for (i in 0 until want.size) {
            wantCounter[want[i]] = number[i]
            counter[want[i]] = 0
        }
        for (item in discount) {
            if (!counter.containsKey(item)) counter[item] = 0
            if (!wantCounter.containsKey(item)) wantCounter[item] = 0
        }
        for (i in 0 until 10) counter[discount[i]] = counter[discount[i]]!! + 1

        var answer = 0
        if (wantCounter == counter) answer ++
        for (day in 10 until discount.size) {
            counter[discount[day-10]] = counter[discount[day-10]]!! - 1
            counter[discount[day]] = counter[discount[day]]!! + 1
            if (wantCounter == counter) answer ++
        }
        return answer
    }
}
