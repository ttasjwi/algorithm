class Solution {
    fun solution(n: Int): IntArray {
        val answer = IntArray((n * (n+1))shr 1)
        var row = 0
        var column = 1
        fun idx(row:Int, column:Int) = ((row * (row - 1)) shr 1) + column - 1
        var number = 1
        var cnt = n
        while (cnt > 0) {
            repeat(cnt) {
                row ++
                answer[idx(row, column)] = number++
            }
            if (--cnt == 0) break
            repeat(cnt) {
                column ++
                answer[idx(row, column)] = number++
            }
            if (--cnt == 0) break
            repeat(cnt) {
                row --
                column --
                answer[idx(row, column)] = number++
            }
            cnt --
        }
        return answer
    }
}