class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val nexts = "abcdefghijklmnopqrstuvwxyz".replace("[$skip]".toRegex(), "")
        val sb = StringBuilder()
        val charReplace = CharArray(26)
        for (i in nexts.indices) {
            charReplace[nexts[i].code - 97] = nexts[(i + index + nexts.length)%nexts.length]
        }

        for (ch in s) sb.append(charReplace[ch.code -97])
        return sb.toString()
    }
}
