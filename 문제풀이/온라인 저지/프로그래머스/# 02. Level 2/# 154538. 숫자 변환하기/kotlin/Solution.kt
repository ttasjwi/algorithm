import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0
        val q: Queue<Int> = LinkedList()
        val check = BooleanArray(y+1)
        q.offer(x)
        check[x] = true
        var depth = -1
        var size: Int
        var cur: Int
        var next: Int
        while (q.isNotEmpty()) {
            depth ++
            size = q.size
            while (size-- > 0) {
                cur = q.poll()
                for (i in 0 until 3) {
                    if (i == 0) next = cur + n
                    else if (i == 1) next = cur shl 1
                    else next = cur * 3
                    if (next == y) return depth + 1
                    else if (next < y && !check[next]) {
                        check[next] = true
                        q.offer(next)
                    }
                }
            }
        }
        return -1
    }
}
