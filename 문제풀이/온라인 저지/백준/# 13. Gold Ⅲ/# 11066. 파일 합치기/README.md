# 문제
- 플랫폼 : 백준
- 번호 : 11066
- 제목 : 파일 합치기
- 난이도 : Gold 3
- 파일로 합칠 때 필요한 최소비용을 계산하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11066" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍
- 크누스 최적화

---

# 풀이
## 풀이1 : O(N^3)
```kotlin
fun main() {
    var t = i()
    val sb = StringBuilder()
    var n: Int
    val a = IntArray(501)
    val d = Array(501) { IntArray(501) }
    val s = IntArray(501)
    var j: Int
    var c: Int
    var rs: Int
    while (t-- > 0) {
        n = i()
        for (i in 1..n) {
            a[i] = i()
            s[i] = s[i - 1] + a[i]
        }
        for (i in 1 until n) {
            d[i][i + 1] = a[i] + a[i + 1]
        }
        for (g in 2 until n) {
            for (i in 1..n - g) {
                j = i + g
                d[i][j] = Integer.MAX_VALUE
                rs = s[j] - s[i - 1]
                for (k in i until j) {
                    c = d[i][k] + d[k + 1][j] + rs
                    if (d[i][j] > c) d[i][j] = c
                }
            }
        }
        sb.append(d[1][n]).append('\n')
    }
    print(sb)
}
```
- dp 배열은 i번 파일부터 j번 파일까지를 합칠 때의 최소비용을 의미한다.
- s배열에는 누적합을 저장한다.
- i이상 j 미만의 임의의 지점 k에서 끊고 i..k 파일까지 합친 것 중 최소비용과 k+1..j 번 파일까지 합친 것 중 최소비용을 합친 뒤 구간의 모든 파일 용량을 합한다.
- 모든 k에 대해서 따져보고 가장 최소 비용이 `dp[i][j]`이다.
- 최종적으로는 `d[1][n]`을 구하면 된다.

## 풀이2: Kruth's optimization (O(N^2))
```kotlin
fun main() {
    var t = i()
    val sb = StringBuilder()
    var n: Int
    val a = IntArray(501)

    val d = Array(501) { IntArray(501) }
    val s = IntArray(501)
    val opt = Array(501){IntArray(501)}
    var c: Int
    var j: Int
    var rs: Int
    while (t-- > 0) {
        n = i()
        for (i in 1..n) {
            a[i] = i()
            s[i] = s[i - 1] + a[i]
        }
        for (i in 1..n) {
            d[i-1][i] = 0
            opt[i-1][i] = i
        }
        for (g in 2 .. n) {
            for (i in 0..n - g) {
                j = i + g
                d[i][j] = Integer.MAX_VALUE
                rs = s[j] - s[i]
                for (k in opt[i][j-1]..opt[i+1][j]) {
                    c = d[i][k] + d[k][j] + rs
                    if (d[i][j] > c) {
                        d[i][j] = c
                        opt[i][j] = k
                    }
                }
            }
        }
        sb.append(d[0][n]).append('\n')
    }
    print(sb)
}
```
- 크누스 최적화를 적용함
- `dp[i][j] = min (dp[i][k] + dp[k][j]) + s[i][j]` (i < k < j)
- (i < k < j 인 k에 대해 i+1부터 j까지의 최소합 비용)
  `opt[i][j-1] <= opt[i][j] <= opt[i+1][j]`
---
