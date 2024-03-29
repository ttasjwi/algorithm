# 문제
- 플랫폼 : 백준
- 번호 : 01463
- 제목 : 1로 만들기
- 난이도 : Silver 3
- 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1463" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
## 풀이1 : 배열에 중간결과 메모이제이션
```kotlin
fun main() {
    val n = i()
    val dp = IntArray(n+1)
    fun dp(n: Int): Int {
        return when {
            n == 1 || dp[n] > 0 -> dp[n]
            n == 2 || n == 3 -> {dp[n] = 1; dp[n]}
            n % 6 == 0 -> {dp[n] = minOf(dp(n/3) , dp(n/2), dp(n-1)) + 1; dp[n]}
            n % 3 == 0 -> {dp[n] = minOf(dp(n/3), dp(n-1)) +1; dp[n]}
            n % 2 == 0 -> {dp[n] = minOf(dp(n/2), dp(n-1)) + 1; dp[n]}
            else -> {dp[n] = dp(n-1) + 1; dp[n]}
        }
    }
    print(dp(n))
}
```
- 개인적으로는 이 풀이가 가장 직관적이고 좋은 풀이라고 생각한다
- n이 1이거나 dp배열 저장값이 0보다 크면 배열 저장값을 반환한다.
- n이 2 거나 3일 경우 배열에 1을 저장하고 배열 저장값을 반환한다.
- 그 외의 경우에는 6의 배수인 경우, 3의 약수인 경우, 2의 약수인 경우, 이들의 약수가 아닌 경우 모든 케이스를 나눠서 문제를 푼다

## 풀이2
```kotlin
fun main() {
    val n = i()
    fun recur(n: Int, cnt: Int): Int {
        return if (n in 0..1) cnt
               else minOf(recur(n/2, cnt+1+n%2), recur(n/3, cnt+1+n%3))
    }
    print(recur(n, 0))
}
```
- 예를 들어 5를 놓고 생각해보면 5->4->2->1 순으로 연산한다.
- 예를 들어 6을 놓고 생각해보면 6->2->1 또는 6->3->1 순으로 연산한다.
- 예를 들어 10을 놓고 생각해보면 10->5->... 또는 10->9->3->1 순으로 연산한다.
- 여기서 유추할 수 있는 것은 어떤 수가 주어질 때 그 수를 2의 배수 또는 3의 배수가 될 때까지
1씩 차감하고 그 후 재귀적으로 횟수를 계산한뒤 두 경우 각각의 횟수 중 최솟값을 구한다는 것이다.
  - 차감하는 과정은 2 또는 3으로 나눈 나머지를 기준으로 한다.
- n에는 연산 대상, cnt는 횟수를 지정하여 recur함수를 반복적으로 호출하면 된다.