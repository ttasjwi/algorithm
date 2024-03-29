# 문제
- 플랫폼 : 백준
- 번호 : 12865
- 제목 : 평범한 배낭
- 난이도 : Gold 5
- 배낭에 넣을 수 있는 물건들의 가치의 최댓값
- 문제 : <a href="https://www.acmicpc.net/problem/12865" target="_blank">링크</a>

---

# 풀이
- 다이나믹 프로그래밍
- 냅색 문제

---

# 풀이

## 풀이1 : 다이나믹 프로그래밍
```kotlin
fun main() {
    val n = i()
    val k = i()
    val dp = Array(n + 1) { IntArray(k + 1) }
    var w: Int
    var v: Int
    for (i in 1..n) {
        w = i()
        v = i()
        for (j in 1..k) {
            dp[i][j] =
                if (w > j) dp[i - 1][j]
                else Math.max(v + dp[i - 1][j - w], dp[i - 1][j])
        }
    }
    print(dp[n][k])
}
```
- 이차원 배열을 선언한다
  - 행 : 1,2,3,... n번째 아이템까지 담을 때
  - 열 : 무게 상한(1,2,3,...k)
- 마진을 두기 위해 배열의 크기를 n+1행 k+1열로 한다
- 물건들이 이렇게 주어졌을 때, 첫번째 요소까지 물건을 삽입할 때, 두번째 요소까지 물건을 삽입할 때, 세번째 요소까지 물건을 삽입할 때 순으로 문제를 확장시켜 나간다.
- 새로 물건을 삽입할 때 선택 가능한 요소는 2가지다
    - 새로 삽입하려는 요소의 무게가 너무 많아서 물건을 삽입할 수 없다.
    - 다음 두개 값 중 최댓값
        - 새로 삽입하려는 요소를 넣고, 남은 용량을 기존 요소들끼리 나눴을 때로 대체하기
        - 새로 삽입하려는 요소를 넣지 않고 기존 요소들끼리 물건을 채우기

## 풀이2 : 최적화
```kotlin
fun main() {
    val n = i()
    val k = i()
    val dp = IntArray(k + 1)
    var w: Int
    var v: Int
    for (i in 1..n) {
        w = i()
        v = i()
        for (j in k downTo w) {
            if (dp[j] < dp[j-w] + v) dp[j] = dp[j-w] + v
        }
    }
    print(dp[k])
}
```
- 일차원 배열 하나만 둬서 공간을 간소화시킨다.
- k부터 w까지 반복시킨다. (w 아래로 가버리면 배낭에 물건을 넣을 수 없음)
- `if (dp[j] < dp[j-w] + v) dp[j] = dp[j-w] + v`
  - 여기서 비교하는 과정에서 참조되는 `dp[j-w]`는 현 지점보다 작은 열의 요소인데, 배열의 돌려 쓰기를 한다면
  작은 열에서부터 반복하면 앞에서 갱신되버리므로 문제를 풀 수 없다.
  - 큰 열부터 반복하면 덮어쓰더라도 이후 작은 열에서는 큰 열쪽을 참조하지 않으므로 배열을 돌려 쓰면서 안전하게 dp 값을 구할 수 있다
- 최종적으로는 `dp[k]`를 출력한다

---
