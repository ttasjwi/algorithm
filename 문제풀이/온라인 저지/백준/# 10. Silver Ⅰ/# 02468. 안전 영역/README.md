# 문제
- 플랫폼 : 백준
- 번호 : 02468
- 제목 : 안전 영역
- 난이도 : Silver 1
- 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2468" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS/BFS

---

# 풀이
```kotlin
private val direction = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

private var n = 0
private lateinit var board: Array<IntArray>
private lateinit var check: Array<BooleanArray>

fun main() {
    n = i()
    board = Array(n) { IntArray(n래) }
    var minHeight = 101
    var maxHeight = -1
    for (r in 0 until n) {
        for (c in 0 until n) {
            board[r][c] = i()
            if (board[r][c] > maxHeight) maxHeight = board[r][c]
            if (board[r][c] < minHeight) minHeight = board[r][c]
        }
    }
    var answer = 0
    var cnt: Int
    for (rainHeight in minHeight - 1 until maxHeight) {
        check = Array(n) { BooleanArray(n) }
        cnt = 0
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (board[r][c] > rainHeight && !check[r][c]) {
                    check[r][c] = true
                    cnt++
                    dfs(r, c, rainHeight)
                }
            }
        }
        if (cnt > answer) answer = cnt
    }
    writeInt(answer)
    flushBuffer()
}

private fun dfs(r: Int, c: Int, rainHeight: Int) {
    var nr: Int
    var nc: Int
    for (d in direction) {
        nr = r + d[0]
        nc = c + d[1]

        if (nr in 0 until n && nc in 0 until n && board[nr][nc] > rainHeight && !check[nr][nc]) {
            check[nr][nc] = true
            dfs(nr, nc, rainHeight)
        }
    }
}
```
- 가능한 침수 높이 케이스마다 dFS를 수행

---
