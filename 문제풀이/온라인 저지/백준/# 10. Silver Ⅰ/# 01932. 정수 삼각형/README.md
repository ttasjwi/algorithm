# 문제
- 플랫폼 : 백준
- 번호 : 01932
- 제목 : 정수 삼각형
- 난이도 : Silver 1
- 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1932" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val dp = Array(n+1) { IntArray(it + 2)}
    var answer = 0
    for (r in 1..n) {
        for (c in 1..r) {
            dp[r][c] = i() + Math.max(dp[r-1][c-1], dp[r-1][c])
            if (r == n) {
                answer = Math.max(dp[r][c], answer)
            }
        }
    }
    print(answer)
}
```
- `dp[r][c]`에는 여태까지 누적했을 때, 해당 행 해당 열로 도착하는 최대비용을 저장한다.
- 이 값은 dp[r-1][c-1] 과 dp[r-1][c] 중 작은 값에 현재 지점의 비용을 합산하여 구해 나가면된다.
- 마지막 행에서는 각 dp[r][...] 값 중 최대비용을 갱신시킨다.
- 최대 비용을 출력한다

---
