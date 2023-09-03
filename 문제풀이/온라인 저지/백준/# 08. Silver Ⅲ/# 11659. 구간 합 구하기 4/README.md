# 문제
- 플랫폼 : 백준
- 번호 : 11659
- 제목 : 구간 합 구하기 4
- 난이도 : Silver 3
- M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11659" target="_blank">링크</a>

---

# 필요 알고리즘
- 누적합

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var m = i()
    val dp = IntArray(n+1)
    for (i in 1..n) dp[i] = dp[i-1] + i()
    val sb = StringBuilder()
    while (m-- > 0) {
        sb.append(-dp[i()-1] + dp[i()]).append('\n')
    }
    print(sb)
}
```
- 누적합 배열을 구하고, 끝점에서 시작점 이전의 누적합을 제거하면 구간의 합을 구할 수 있다.

---
