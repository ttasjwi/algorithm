private const val EMPTY_STRING = ""
private const val OPEN_CHAR = '('
private const val CLOSE_CHAR = ')'

class Solution {

    fun solution(p: String): String {
        if (p == EMPTY_STRING) return p
        val split = split(p)
        val u = split.first
        val v = split.second

        val sb = StringBuilder()
        if (isRight(u)) {
            sb.append(u)
            sb.append(solution(v))
            return sb.toString()
        }
        sb.append(OPEN_CHAR)
        sb.append(solution(v))
        sb.append(CLOSE_CHAR)
        for (i in 1..u.length - 2) {
            if (u[i] == OPEN_CHAR) sb.append(CLOSE_CHAR)
            else sb.append(OPEN_CHAR)
        }
        return sb.toString()
    }

    private fun split(w: String): Pair<String, String> {
        var i = 0
        var open = 0
        var close = 0
        while (i < w.length) {
            if (w[i] == OPEN_CHAR) open++
            else close++
            if (open == close) break
            i++
        }
        return Pair(w.substring(0, i + 1), if (i + 1 == w.length) EMPTY_STRING else w.substring(i + 1))
    }

    private fun isRight(u: String): Boolean {
        var open = 0
        for (ch in u) {
            if (ch == OPEN_CHAR) open++
            else if (open == 0) return false
            else open--
        }
        return open == 0
    }
}
