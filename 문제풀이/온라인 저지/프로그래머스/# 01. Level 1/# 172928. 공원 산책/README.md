# 문제
- 플랫폼 : 프로그래머스
- 번호 : 172928
- 제목 : 공원 산책
- 난이도 : Level 1
- 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 세로 방향 좌표, 가로 방향 좌표 순으로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/172928" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
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
```
- 맵에 방향을 저장해둔다.
- 시작점을 찾는다.
- 시작점에서 시작하여 지정 방향으로 지정횟수만큼 이동하면서 안전하지 않으면 이동을 취소한다.
- 지정횟수만큼 이동하면서 확인시 안전하면 이동을 확정한다.
- 최종 위치를 반환한다.
