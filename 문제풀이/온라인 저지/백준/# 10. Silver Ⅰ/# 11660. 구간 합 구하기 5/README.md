# 문제
- 플랫폼 : 백준
- 번호 : 11660
- 제목 : 구간 합 구하기 5
- 난이도 : Silver 1
- 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11660" target="_blank">링크</a>

---

# 필요 지식
- 누적합

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var m = i()
    val dp = Array(n+1){IntArray(n+1)}
    for (x in 1..n) {
        for (y in 1..n) {
            dp[x][y] = dp[x-1][y] + dp[x][y-1] - dp[x-1][y-1] + i()
        }
    }
    val sb = StringBuilder()
    var x1: Int
    var y1: Int
    var x2: Int
    var y2: Int
    while (m -- >0) {
        x1 = i()
        y1 = i()
        x2 = i()
        y2 = i()
        sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]).append('\n')
    }
    print(sb)
}
```
- dp 배열에 누적합을 저장한다. 저장하는 방식은, 상단값 좌측값을 합하고 좌상단 값을 뺀 뒤 새로 들어온 입력을 추가해주면 된다
- 구간합을 구하는 법은 다음과 같다
  - 누적합에서
  - 시작열 끝행 왼쪽까지의 합을 뺀다
  - 시작행 끝열 윗쪽까지의 합을 뺀다
  - 시작행 시작열 왼쪽 위까지의 합을 더한다(중복)

