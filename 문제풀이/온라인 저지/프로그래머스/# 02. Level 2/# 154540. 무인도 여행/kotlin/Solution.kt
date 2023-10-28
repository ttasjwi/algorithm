import java.util.*

class Solution {
    private val dr = intArrayOf(0, 1, 0, -1)
    private val dc = intArrayOf(1, 0, -1, 0)

    fun solution(maps: Array<String>): IntArray {
        val width = maps[0].length
        val height = maps.size
        val board = Array(height) { r -> IntArray(width) { c ->
            if (maps[r][c] == 'X') 0 else maps[r][c].code - 48 }
        }

        var sum = 0
        fun dfs(r: Int, c: Int) {
            var nr: Int
            var nc: Int
            for (i in 0 until 4) {
                nr = r + dr[i]
                nc = c + dc[i]
                if ((nr in 0 until height) && (nc in 0 until width) && board[nr][nc] > 0) {
                    sum += board[nr][nc]
                    board[nr][nc] = 0
                    dfs(nr, nc)
                }
            }
        }

        val answer = ArrayList<Int>()

        for (r in 0 until height) {
            for (c in 0 until width) {
                if (board[r][c] > 0) {
                    sum = board[r][c]
                    board[r][c] = 0
                    dfs(r, c)
                    answer += sum
                }
            }
        }
        if (answer.isEmpty()) {
            return intArrayOf(-1)
        }
        else {
            answer.sort()
            return answer.toIntArray()
        }
    }
}