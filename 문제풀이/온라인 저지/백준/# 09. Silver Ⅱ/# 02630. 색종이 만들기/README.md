# 문제
- 플랫폼 : 백준
- 번호 : 02630
- 제목 : 색종이 만들기
- 난이도 : Silver 2
- 잘라진 햐얀색 색종이, 파란색 색종이의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2630" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val board = Array(n) { BooleanArray(n) }
    var wh = 0
    var bl = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            board[i][j] = b()
        }
    }
    fun div(sr:Int, sc:Int, len: Int) {
        for (r in sr until sr+len) {
            for (c in sc until sc+len) {
                if (board[r][c] != board[sr][sc]) {
                        val nLen = len/2
                        div(sr, sc, nLen)
                        div(sr, sc+nLen, nLen)
                        div(sr+nLen, sc, nLen)
                        div(sr+nLen, sc+nLen, nLen)
                        return
                }
            }
        }
        if (board[sr][sc]) bl ++ else wh ++
    }
    div(0, 0, n)
    val sb = StringBuilder()
    sb.append(wh).append('\n').append(bl)
    print(sb)
}
```
- 순서대로 순회하면서 첫번째에 위치한 값과 일치하지 않으면 다시 색종이를 사분할하여 카운팅

---
