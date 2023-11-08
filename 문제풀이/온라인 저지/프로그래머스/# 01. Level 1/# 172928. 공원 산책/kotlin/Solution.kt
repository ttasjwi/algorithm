class Solution {

    private val directions = mapOf(
        'E' to intArrayOf(0,1),
        'S' to intArrayOf(1,0),
        'W' to intArrayOf(0,-1),
        'N' to intArrayOf(-1,0)
    )

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var (r, c) = findStart(park)

        loop@for (route in routes) {
            val direction = directions[route[0]]!!
            var k = route[2].code - 48
            var cr = r
            var cc = c
            while (k-- > 0) {
                cr += direction[0]
                cc += direction[1]
                if (!isSafe(park, cr, cc)) {
                    continue@loop
                }
            }
            r = cr
            c = cc
        }
        return intArrayOf(r,c)
    }

    private fun findStart(park: Array<String>): Pair<Int, Int> {
        for (r in park.indices) {
            for (c in park[0].indices) {
                if (park[r][c] == 'S') {
                    return Pair(r,c)
                }
            }
        }
        throw AssertionError("절대 일어날 일 없음")
    }


    private fun isSafe(park: Array<String>, cr: Int, cc: Int) =
        ((cr in park.indices) && (cc in park[0].indices) && (park[cr][cc] != 'X'))
}
