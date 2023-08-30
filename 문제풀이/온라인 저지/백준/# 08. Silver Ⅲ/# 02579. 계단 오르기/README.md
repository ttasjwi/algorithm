# 문제
- 플랫폼 : 백준
- 번호 : 02579
- 제목 : 계단 오르기
- 난이도 : Silver 3
- 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2579" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = IntArray(n + 1)
    val dp = IntArray(n + 1)
    for (i in 1..n) {
        c[i] = i()
        dp[i] = when (i) {
            1 -> c[i]
            2 -> c[i - 1] + c[i]
            else -> c[i] + Math.max(dp[i - 3] + c[i - 1], dp[i - 2])
        }
    }
    print(dp[n])
}
```
- i번째 계단에 오기까지 얻을 수 있는 최대 점수를 scores[i]라 하자.
- i번 계단에 오기까지 얻을 수 있는 최대 점수는, i-3번 계단까지 최대 점수를 얻고, i-2번, i번 계단에 온 경우와, i-2번까지 최대 점수를 얻고 i번 계단에 온 경우 두 경우 중 최댓값이다.

---
