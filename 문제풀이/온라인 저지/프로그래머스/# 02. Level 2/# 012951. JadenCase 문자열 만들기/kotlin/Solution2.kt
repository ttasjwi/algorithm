class Solution2 {
    fun solution(s: String) = s.lowercase().split(' ').map { it.capitalize() }.joinToString(" ")
}
