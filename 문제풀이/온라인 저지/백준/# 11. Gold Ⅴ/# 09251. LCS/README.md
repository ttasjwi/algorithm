# 문제
- 플랫폼 : 백준
- 번호 : 09251
- 제목 : LCS
- 난이도 : Gold 5
- 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9251" target="_blank">링크</a>

---

# 풀이
- LCS(최장 공통 부분수열)
- DP(다이나믹 프로그래밍)

---

# 풀이
```kotlin
fun main() {
    val a = s()
    val b = s()
    val dp = Array(a.size) { IntArray(b.size) }
    for (i in 1..a.size - 1) {
        for (j in 1..b.size - 1) {
            dp[i][j] =
                if (a[i] == b[j]) dp[i - 1][j - 1] + 1
                else Math.max(dp[i - 1][j], dp[i][j - 1])
        }
    }
    sb.append(dp[a.size - 1][b.size - 1])
    print(sb)
}
```
- 최장 공통 부분 수열의 길이는 DP 를 적용해 풀어야한다
- 문자열의 맨앞에 빈 공백을 하나씩 둔다.(계산의 편의를 위함)
- `dp[i][j]` 의 의미 : 문자열 a의 i번째 인덱스까지의 문자열과, 문자열 j의 인덱스까지의 문자열의 최장 공통 부분수열
  - 0행 또는 0열의 요소는 0으로 초기화한다.
  - `a[i]`, `b[j]`를 비교하여, 둘이 같다면 바로 앞까지 `dp[i-1][j-1]` 에 1 을 더한다
  - 서로 다르면, `dp[i-1][j]` 와 `dp[i][j-1]` 의 최댓값으로 채운다.
- 이렇게 쭉 구하면서 계산을 완료하면 `dp[a.size-1][b.size-1]` 을 출력한다.
