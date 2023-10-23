class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val answer = IntArray(2)
        fun div(sr:Int, sc:Int, len:Int) {
            val nextLen = len shr 1
            for (r in sr until sr+len) {
                for (c in sc until sc+len) {
                    if (arr[r][c] != arr[sr][sc]) {
                        div(sr,sc, nextLen)
                        div(sr+nextLen, sc, nextLen)
                        div(sr, sc+nextLen, nextLen)
                        div(sr+nextLen, sc+nextLen, nextLen)
                        return
                    }
                }
            }
            if (arr[sr][sc] == 0) {
                answer[0] ++
            } else {
                answer[1] ++
            }
        }
        div(0, 0, arr.size)
        return answer
    }
}