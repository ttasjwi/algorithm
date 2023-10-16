class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()
        for (arr in clothes) {
            if (!map.containsKey(arr[1])) {
                map[arr[1]] = 1
            } else {
                map[arr[1]] = map[arr[1]]!! + 1
            }
        }
        var answer = 1
        for (v in map.values) {
            answer *= (v+1)
        }
        return answer - 1
    }
}