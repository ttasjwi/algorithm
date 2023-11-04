# 문제
- 플랫폼 : 프로그래머스
- 번호 : 169199
- 제목 : 리코쳇 로봇
- 난이도 : Level 2
- 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/169199" target="_blank">링크</a>

---

# 필요 지식
- BFS
- 큐

---

# 풀이
```kotlin
class Solution {

    private val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0) )

    fun solution(board: Array<String>): Int {
        val q = Queue(board.size * board[0].length)
        val check = Array(board.size) {BooleanArray(board[0].length)}
        loop@for (r in board.indices) {
            for (c in board[0].indices) {
                if (board[r][c] == 'R') {
                    q.enQueue(Coordinate(r, c))
                    check[r][c] = true
                    break@loop
                }
            }
        }
        var depth = -1
        var size: Int
        var cur: Coordinate
        var cr: Int
        var cc: Int
        var nr: Int
        var nc: Int
        while (q.isNotEmpty()) {
            depth ++
            size = q.size
            while (size-- > 0) {
                cur = q.deQueue()
                for (arr in d) {
                    cr = cur.r
                    cc = cur.c
                    nr = cr + arr[0]
                    nc = cc + arr[1]
                    while ((nr in board.indices) && (nc in board[0].indices)
                        && board[nr][nc] != 'D') {
                        cr = nr
                        cc = nc
                        nr = cr + arr[0]
                        nc = cc + arr[1]
                    }
                    if (!check[cr][cc]) {
                        if (board[cr][cc] == 'G') return depth + 1
                        check[cr][cc] = true
                        q.enQueue(Coordinate(cr, cc))
                    }
                }
            }
        }
        return -1
    }



}

class Queue(cap: Int) {
    private val c = cap + 1
    private val arr = arrayOfNulls<Coordinate>(c)

    var size = 0
        private set
    private var f = 0
    private var r = 0

    fun enQueue(e: Coordinate) {
        arr[((r+1+c)%c).also{r = it; size ++}] = e
    }

    fun deQueue(): Coordinate {
        val nf = (f+1+c)%c
        val e = arr[nf]!!
        arr[nf] = null
        f = nf
        size --
        return e
    }

    fun isNotEmpty() = size != 0
}

class Coordinate(val r: Int, val c: Int)
```
- 시작 위치를 큐에 삽입하고 방문처리 한다.
- 큐가 빌 때까지 다음을 반복한다.
  - depth 증가
  - 큐의 요소 갯수만큼 다음을 반복
    - 큐에서 위치 추출
    - 해당 좌표에서 상하좌우로 더 이상 이동할 수 없을 때까지 이동
    - 도착한 위치가 방문하지 않은 위치일 때
      - goal 이면  depth+1 반환
      - 방문 처리 후 큐 삽입
- 끝까지 탐색해서 골을 찾지 못 했다면 -1 반환

---
