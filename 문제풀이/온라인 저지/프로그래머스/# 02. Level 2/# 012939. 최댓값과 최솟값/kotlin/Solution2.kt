class Solution2 {
    fun solution(s: String): String = s.split(' ').map { it.toInt() }.let { "${it.min()} ${it.max()}" }

}