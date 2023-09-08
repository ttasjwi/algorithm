# 문제
- 플랫폼 : 백준
- 번호 : 01992
- 제목 : 쿼드트리
- 난이도 : Silver 1
- 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1992" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val video = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            video[i][j] = b()
        }
        r()
    }
    val sb = StringBuilder()
    fun div(sr: Int, sc: Int, len: Int) {
        for (r in sr until sr + len) {
            for (c in sc until sc + len) {
                if (video[r][c] != video[sr][sc]) {
                    sb.append('(')
                    val nLen = len shr 1
                    div(sr, sc, nLen)
                    div(sr, sc + nLen, nLen)
                    div(sr + nLen, sc, nLen)
                    div(sr + nLen, sc + nLen, nLen)
                    sb.append(')')
                    return
                }
            }
        }
        sb.append(if (video[sr][sc]) '1' else '0')
    }
    div(0, 0, n)
    print(sb)
}
```
- 쭉 읽어가면서 처음 요소랑 같지 않은 부분을 발견하면 괄호를 열고 사분할하여 재귀적으로 압축한 뒤 괄호를 닫는다

---
