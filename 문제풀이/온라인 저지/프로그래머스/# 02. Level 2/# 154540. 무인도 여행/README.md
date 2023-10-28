# 문제
- 플랫폼 : 프로그래머스
- 번호 : 154540
- 제목 : 무인도 여행
- 난이도 : Level 2
- 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154540" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```kotlin
import java.util.*

class Solution {
    private val dr = intArrayOf(0, 1, 0, -1)
    private val dc = intArrayOf(1, 0, -1, 0)

    fun solution(maps: Array<String>): IntArray {
        val width = maps[0].length
        val height = maps.size
        val board = Array(height) { r -> IntArray(width) { c ->
            if (maps[r][c] == 'X') 0 else maps[r][c].code - 48 }
        }

        var sum = 0
        fun dfs(r: Int, c: Int) {
            var nr: Int
            var nc: Int
            for (i in 0 until 4) {
                nr = r + dr[i]
                nc = c + dc[i]
                if ((nr in 0 until height) && (nc in 0 until width) && board[nr][nc] > 0) {
                    sum += board[nr][nc]
                    board[nr][nc] = 0
                    dfs(nr, nc)
                }
            }
        }

        val answer = ArrayList<Int>()

        for (r in 0 until height) {
            for (c in 0 until width) {
                if (board[r][c] > 0) {
                    sum = board[r][c]
                    board[r][c] = 0
                    dfs(r, c)
                    answer += sum
                }
            }
        }
        if (answer.isEmpty()) {
            return intArrayOf(-1)
        }
        else {
            answer.sort()
            return answer.toIntArray()
        }
    }
}
```
- 문자열 파싱 : 문자가 'X' 이면 해당 위치의 숫자를 0으로 카운팅하고, 그 외에는 숫자를 저장한다.
- DFS
  - 숫자가 0보다 큰 곳을 찾아내면 연속한 숫자가 0이 아닌 지점을 연쇄적으로 탐색
  - 이 과정에서 구해진 sum을 answer에 추가
- answer이 비어있으면 -1이 담긴 배열을 반환하고, 그렇지 않으면 정렬해서 반환

---
