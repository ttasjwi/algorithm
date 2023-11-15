class Solution {
    fun solution(myString: String): String {
        val sb = StringBuilder()
        for (ch in myString) {
            if (ch == 'a') {
                sb.append('A')
            } else if (ch in 'B'..'Z') {
                sb.append((ch.code + 32).toChar())
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }
}
