# 문제
- 플랫폼 : 백준
- 번호 : 01780
- 제목 : 종이의 개수
- 난이도 : Silver 2
- 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1780" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val board = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            board[i][j] = i()
        }
    }
    var m = 0
    var z = 0
    var p = 0
    fun div(sr: Int, sc: Int, len: Int) {
        for (r in sr until sr + len) {
            for (c in sc until sc + len) {
                if (board[r][c] != board[sr][sc]) {
                    val nLen = len/3
                    if (nLen == 1) {
                        for (i in 0 until 3) {
                            for (j in 0 until 3) {
                                when (board[sr+i][sc+j]) {
                                    -1 -> m++
                                    0 -> z++
                                    1 -> p++
                                }
                            }
                        }
                        return
                    }
                    for (i in 0 until 3) {
                        for (j in 0 until 3) {
                            div(sr+nLen*i, sc+nLen*j, nLen)
                        }
                    }
                    return
                }
            }
        }
        when (board[sr][sc]) {
            -1 -> m++
            0 -> z++
            1 -> p++
        }
    }
    div(0,0, n)
    val sb = StringBuilder()
    sb.append(m).append('\n').append(z).append('\n').append(p)
    print(sb)
}
```
- 행렬을 전부 순서대로 순회하다가 다른 숫자가 나왔다면, 행렬을 9등분하여 다시 순회한다.
  - 재귀적으로 순회하면 된다.
- 그런데 이렇게 재귀적으로 순회하더라도 3*3 수준까지 재귀적으로 순회하는 것은 순회 비용이 커지므로
3*3 수준은 1*1로 쪼개 재귀함수를 호출하지 않고, 바로 직접 카운터를 증가시킨다.

---
