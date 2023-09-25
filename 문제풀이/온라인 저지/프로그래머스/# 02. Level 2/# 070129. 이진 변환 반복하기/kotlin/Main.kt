import java.util.*

class Solution {
    fun solution(s: String): IntArray {
        var x = s
        val sb= StringBuilder()
        var cnt = 0
        var delete = 0
        while (x != "1") {
            for (ch in x) {
                if (ch == '0') delete ++
                else sb.append(ch)
            }
            x = sb.length.toString(2)
            cnt ++
            sb.setLength(0)
        }
        return intArrayOf(cnt, delete)
    }

}