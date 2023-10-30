# 문제
- 플랫폼 : 프로그래머스
- 번호 : 077487
- 제목 : 행렬 테두리 회전하기
- 난이도 : Level 2
- 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77487" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
class Solution {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val board = Array(rows+1) {row -> IntArray(columns+1) { column -> ((columns) * (row-1)) + column }}
        fun rotate(sr:Int, sc:Int, er:Int, ec: Int): Int {
            var cr = sr
            var cc = sc
            fun nextRow(cr: Int, cc:Int): Int {
                return when {
                    (cr == sr && cc in sc until ec) -> cr
                    (cc == ec && cr in sr until er) -> cr + 1
                    (cr == er && cc in sc+1..ec) -> cr
                    else -> cr - 1
                }
            }
            fun nextColumn(cr: Int, cc: Int): Int {
                return when {
                    (cr == sr && cc in sc until ec) -> cc + 1
                    (cc == ec && cr in sr until er) -> cc
                    (cr == er && cc in sc + 1..ec) -> cc - 1
                    else -> cc
                }
            }
            var nr = nextRow(cr, cc)
            var nc = nextColumn(cr, cc)
            var backup = board[sr][sc]
            var result = backup
            while(nr != sr || nc != sc) {
                board[nr][nc] = backup.also{backup = board[nr][nc]}
                if (backup < result) result = backup
                cr = nr
                cc = nc
                nr = nextRow(cr, cc)
                nc = nextColumn(cr, cc)
            }
            board[sr][sc] = backup
            return result
        }
        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3])
        }
        return answer
    }
}
```
- rotate : 시계방향 1칸 회전
- nextRow 함수 : 다음으로 이동할 행
- newtColumn 함수 : 다음으로 이동할 열
- backup : 다음 이동할 자리의 저장값. 이 변수에 백업한다.