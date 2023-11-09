class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer = intArrayOf(50,50,0,0)

        for (r in wallpaper.indices) {
            for (c in wallpaper[0].indices) {
                if (wallpaper[r][c] == '#') {
                    if (r < answer[0]) answer[0] = r
                    if (c < answer[1]) answer[1] = c
                    if (r+1 > answer[2]) answer[2] = r+1
                    if (c+1 > answer[3]) answer[3] = c+1
                }
            }
        }
        return answer
    }
}
