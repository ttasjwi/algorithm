class Solution {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val board = Array(rows+1) {row -> IntArray(columns+1) { column -> ((columns) * (row-1)) + column }}
        fun rotate(sr:Int, sc:Int, er:Int, ec: Int): Int {
            var cr = sr
            var cc = sc
            fun nextRow(cr: Int, cc:Int): Int {
                return when {
                    (cr == sr && cc in sc until ec) -> cr
                    (cc == ec && cr in sr until er) -> cr + 1
                    (cr == er && cc in sc+1..ec) -> cr
                    else -> cr - 1
                }
            }
            fun nextColumn(cr: Int, cc: Int): Int {
                return when {
                    (cr == sr && cc in sc until ec) -> cc + 1
                    (cc == ec && cr in sr until er) -> cc
                    (cr == er && cc in sc + 1..ec) -> cc - 1
                    else -> cc
                }
            }
            var nr = nextRow(cr, cc)
            var nc = nextColumn(cr, cc)
            var backup = board[sr][sc]
            var result = backup
            while(nr != sr || nc != sc) {
                board[nr][nc] = backup.also{backup = board[nr][nc]}
                if (backup < result) result = backup
                cr = nr
                cc = nc
                nr = nextRow(cr, cc)
                nc = nextColumn(cr, cc)
            }
            board[sr][sc] = backup
            return result
        }
        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3])
        }
        return answer
    }


}

