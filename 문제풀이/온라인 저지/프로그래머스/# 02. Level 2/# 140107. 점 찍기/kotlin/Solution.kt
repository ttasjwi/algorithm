import kotlin.math.sqrt

class Solution {
    fun solution(k: Int, d: Int): Long {
        val md2 = d.toLong() * d.toLong()
        fun d2(x: Int, y: Int): Long {
            val lx = x.toLong()
            val ly = y.toLong()
            return lx * lx + ly * ly
        }
        fun count(startEx: Int, endIn: Int) = (endIn - startEx)/k

        var answer: Long = 0
        val maxStart = sqrt(md2/2.0).toInt()
        answer += count(0, maxStart) + 1
        var d2: Long
        for (start in 0..maxStart step k) {
            var lt = start
            var rt = d
            var end = -1
            loop@while (lt <= rt) {
                val mid = (lt + rt) shr 1
                d2 = d2(mid, start)
                if (d2 == md2) {
                    end = mid
                    break@loop
                } else if (d2 < md2) {
                    lt = mid + 1
                    end = mid
                } else {
                    rt = mid - 1
                }
            }
            answer += count(start, end) shl 1
        }
        return answer
    }

}