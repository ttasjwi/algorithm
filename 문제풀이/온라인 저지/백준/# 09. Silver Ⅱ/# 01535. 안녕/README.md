# 문제
- 플랫폼 : 백준
- 번호 : 01535
- 제목 : 안녕
- 난이도 : Silver 2
- 세준이가 얻을 수 있는 최대 기쁨을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1535" target="_blank">링크</a>

---

# 필요 지식
- 냅색 알고리즘
- DP

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val l = IntArray(n+1)
    val j = IntArray(n+1)
    for (i in 1..n) l[i] = i()
    for (i in 1..n) j[i] = i()

    val maxLife = 99
    val dp = IntArray(maxLife + 1)
    var alt: Int
    for (i in 1..n) {
        for (k in maxLife downTo 1) {
            if (k >= l[i]) {
                alt = dp[k-l[i]] + j[i]
                if (dp[k] < alt) dp[k] = alt
            }
        }
    }
    writeInt(dp[maxLife])
    flushBuffer()
}
```
- dp : 0,1,...99 (해당 생명력까지 있는 자원 다 소모해서 인사했을 때 얻을 수 있는 최대 행복)
- 1번째 사람, 2번째 사람, ... 3번째 사람에 대하여
  - 현재 생명력이 해당 사람과의 인사로 소모되는 생명력보다 크거나 같을 경우
  - `dp[i]`를 갱신시킨다.
- 같은 배열을 돌려쓰기 식으로 사용하고 있기 때문에 99부터 1까지 역순으로 순회해야한다.

---
