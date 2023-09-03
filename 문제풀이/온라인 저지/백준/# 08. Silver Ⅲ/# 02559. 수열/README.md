# 문제
- 플랫폼 : 백준
- 번호 : 02559
- 제목 : 수열
- 난이도 : Silver 3
- 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2559" target="_blank">링크</a>

---

# 필요 지식
- 누적합

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val k = i()
    val dp = IntArray(n+1)
    for (i in 1..n) dp[i] = dp[i-1] + i()
    var answer = -10_000_000
    for (i in n downTo k) {
        answer = Math.max(answer, dp[i] - dp[i-k])
    }
    print(answer)
}

- 누적합을 구해둔다
- n번째부터 k번째 항까지 순서대로 내려가면서 연속된 k개의 합의 최댓값을 갱신한다