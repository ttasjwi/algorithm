class Solution {

    private val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0) )

    fun solution(board: Array<String>): Int {
        val q = Queue(board.size * board[0].length)
        val check = Array(board.size) {BooleanArray(board[0].length)}
        loop@for (r in board.indices) {
            for (c in board[0].indices) {
                if (board[r][c] == 'R') {
                    q.enQueue(Coordinate(r, c))
                    check[r][c] = true
                    break@loop
                }
            }
        }
        var depth = -1
        var size: Int
        var cur: Coordinate
        var cr: Int
        var cc: Int
        var nr: Int
        var nc: Int
        while (q.isNotEmpty()) {
            depth ++
            size = q.size
            while (size-- > 0) {
                cur = q.deQueue()
                for (arr in d) {
                    cr = cur.r
                    cc = cur.c
                    nr = cr + arr[0]
                    nc = cc + arr[1]
                    while ((nr in board.indices) && (nc in board[0].indices)
                        && board[nr][nc] != 'D') {
                        cr = nr
                        cc = nc
                        nr = cr + arr[0]
                        nc = cc + arr[1]
                    }
                    if (!check[cr][cc]) {
                        if (board[cr][cc] == 'G') return depth + 1
                        check[cr][cc] = true
                        q.enQueue(Coordinate(cr, cc))
                    }
                }
            }
        }
        return -1
    }



}

class Queue(cap: Int) {
    private val c = cap + 1
    private val arr = arrayOfNulls<Coordinate>(c)

    var size = 0
        private set
    private var f = 0
    private var r = 0

    fun enQueue(e: Coordinate) {
        arr[((r+1+c)%c).also{r = it; size ++}] = e
    }

    fun deQueue(): Coordinate {
        val nf = (f+1+c)%c
        val e = arr[nf]!!
        arr[nf] = null
        f = nf
        size --
        return e
    }

    fun isNotEmpty() = size != 0
}

class Coordinate(val r: Int, val c: Int)