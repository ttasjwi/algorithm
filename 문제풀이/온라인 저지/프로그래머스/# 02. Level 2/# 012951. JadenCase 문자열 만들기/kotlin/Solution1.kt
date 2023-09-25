class Solution1 {
    fun solution(s: String): String {
        var isStartChar = true
        val sb = StringBuilder()
        for (i in s.indices) {
            if (s[i] == ' ') {
                sb.append(s[i])
                isStartChar = true
            } else if (isStartChar) {
                sb.append(s[i].uppercaseChar())
                isStartChar = false
            } else {
                sb.append(s[i].lowercaseChar())
            }
        }
        return sb.toString()
    }
}
