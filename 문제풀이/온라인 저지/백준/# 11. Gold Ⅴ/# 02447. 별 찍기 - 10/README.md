# 문제
- 플랫폼 : 백준
- 번호 : 02447
- 제목 : 별 찍기 - 10
- 난이도 : Gold 5
- 첫째 줄부터 N번째 줄까지 별을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2447" target="_blank">링크</a>

---

# 풀이
- 재귀
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val n = i()
    board = Array(n) { CharArray(n) }
    foo(0, 0, n, false)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (b in board) {
        bw.write(b)
        bw.newLine()
    }
    bw.flush()
}

fun foo(sr: Int, sc: Int, len: Int, isBlank: Boolean) {
    if (isBlank) {
        for (i in sr..sr + len - 1) {
            for (j in sc..sc + len - 1) {
                board[i][j] = ' '
            }
        }
        return
    }
    if (len == 1) {
        board[sr][sc] = '*'
        return
    }
    val n = len / 3
    for (i in 0..2) {
        for (j in 0..2) {
            foo(sr + n * i, sc + n * j, n, (i == 1 && j == 1))
        }
    }
    return
}
```
- 가운데는 전부 공백으로 비우고 나머지 영역은 재귀적으로 반복한다.
- 1칸 영역은 별로 채운다.

---
