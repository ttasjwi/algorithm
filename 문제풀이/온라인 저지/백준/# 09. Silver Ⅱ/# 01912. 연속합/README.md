# 문제
- 플랫폼 : 백준
- 번호 : 01912
- 제목 : 연속합
- 난이도 : Silver 2
- 첫째 줄에 답을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1912" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
## 풀이1: 브루트 포스 -> 실패
```kotlin
fun main() {
    val n = i()
    val sums = IntArray(n+1)
    var input: Int
    for (i in 1..n) {
        input = i()
        sums[i] = sums[i-1] + input
    }
    var max = -1001
    for (lt in 1..n) {
        for (rt in lt..n) {
            max = (sums[rt] - sums[lt-1]).coerceAtLeast(max)
        }
    }
    print(max)
}
```
- 누적합을 배열에 저장하고, 모든 lt, rt를 잡아서 누적합의 최댓값을 갱신
- 시간 복잡도가 O(N^2) 이라서 통과할 수 없다

## 풀이2: 다이나믹 프로그래밍
```kotlin
fun main() {
    val n = i()
    var input: Int
    var max = -1001
    var current = 0 // 임의의 값에서 시작해서 누적했을 때, 현 시점에서 최대가 되는 연속합
    for (i in 1..n) {
        input = i()
        current = if (current + input > input) current + input else input
        max = if (current > max) current else max // 연속합의 최댓값
    }
    print(max)
}
```
- current 변수에, 어떤 값에서 시작하여, 해당 시점까지 누적했을 때 현 시점에서 최대가 되도록 하는 연속합을 저장한다.
- 이전 지점까지의 current와 현재 입력값을 비교하여 더 큰 쪽을 current로 갱신한다.
- 이전까지 최대 누적합에 현재 값을 더하는 것보다, 현재 값부터 시작하는 것이 더 크다면 이전까지의 누적합을 버리고 현재 지점에서 누적합을 시작하는 것이 더 바람직하다.
- 이렇게 계산된 current와 max를 매 순간 비교하여 max를 갱신한다.
- max를 출력하면 된다

---
