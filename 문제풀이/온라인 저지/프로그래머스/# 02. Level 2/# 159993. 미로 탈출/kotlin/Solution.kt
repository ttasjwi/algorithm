class Solution {

    private val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

    fun solution(maps: Array<String>): Int {
        var check = Array(maps.size) { BooleanArray(maps[0].length) }
        val q = Queue(maps.size * maps[0].length)

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] == 'S') {
                    q.enQueue(intArrayOf(i, j))
                    check[i][j] = true
                    break
                }
            }
        }

        var size: Int
        var cur: IntArray
        var nr: Int
        var nc: Int

        var lr = 0
        var lc = 0
        var depth = -1
        var find = false
        loop@ while (q.isNotEmpty()) {
            if (find) {
                q.deQueue()
                continue
            }
            size = q.size
            depth++
            while (size-- > 0) {
                cur = q.deQueue()
                for (i in 0 until 4) {
                    nr = cur[0] + d[i][0]
                    nc = cur[1] + d[i][1]
                    if ((nr in maps.indices) && (nc in maps[0].indices) && maps[nr][nc] != 'X' && !check[nr][nc]) {
                        if (maps[nr][nc] == 'L') {
                            lr = nr
                            lc = nc
                            find = true
                            continue@loop
                        }
                        check[nr][nc] = true
                        q.enQueue(intArrayOf(nr, nc))
                    }
                }
            }
        }
        if (!find) return -1
        check = Array(maps.size) { BooleanArray(maps[0].length) }
        check[lr][lc] = true
        q.enQueue(intArrayOf(lr, lc))
        while (q.isNotEmpty()) {
            size = q.size
            depth++
            while (size-- > 0) {
                cur = q.deQueue()
                for (i in 0 until 4) {
                    nr = cur[0] + d[i][0]
                    nc = cur[1] + d[i][1]
                    if ((nr in maps.indices) && (nc in maps[0].indices) && maps[nr][nc] != 'X' && !check[nr][nc]) {
                        if (maps[nr][nc] == 'E') {
                            return depth + 1
                        }
                        check[nr][nc] = true
                        q.enQueue(intArrayOf(nr, nc))
                    }
                }
            }
        }
        return -1
    }

}

class Queue(cap: Int) {

    private val c = cap + 1
    private val arr = arrayOfNulls<IntArray>(c)
    var size = 0
        private set
    private var f = 0
    private var r = 0

    fun enQueue(e: IntArray) {
        arr[((r + 1 + c) % c).also { r = it; size++ }] = e
    }

    fun deQueue(): IntArray {
        val next = (f + 1 + c) % c
        val e = arr[next]!!
        arr[next] = null
        f = next
        size--
        return e
    }

    fun isNotEmpty() = size != 0

}
