class Solution {

    private val map = mapOf(
        "RT" to intArrayOf(0,3,2,1,0,-1,-2,-3),
        "TR" to intArrayOf(0,-3,-2,-1,0,1,2,3),
        "CF" to intArrayOf(1,3,2,1,0,-1,-2,-3),
        "FC" to intArrayOf(1,-3,-2,-1,0,1,2,3),
        "JM" to intArrayOf(2,3,2,1,0,-1,-2,-3),
        "MJ" to intArrayOf(2,-3,-2,-1,0,1,2,3),
        "AN" to intArrayOf(3,3,2,1,0,-1,-2,-3),
        "NA" to intArrayOf(3,-3,-2,-1,0,1,2,3)
    )

    fun solution(survey: Array<String>, choices: IntArray): String {
        val arr = IntArray(4)

        for (i in choices.indices) {
            val idx = map[survey[i]]!![0]
            val point = map[survey[i]]!![choices[i]]
            arr[idx] += point
        }
        val result = CharArray(4)
        result[0] = if (arr[0] >= 0) 'R' else 'T'
        result[1] = if (arr[1] >= 0) 'C' else 'F'
        result[2] = if (arr[2] >= 0) 'J' else 'M'
        result[3] = if (arr[3] >= 0) 'A' else 'N'
        return String(result)
    }
}
