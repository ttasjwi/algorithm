# 문제
- 플랫폼 : 백준
- 번호 : 13974
- 제목 : 파일 합치기 2
- 난이도 : Platinum 2
- 학생들을 앞에서부터 줄을 세운 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13974" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍
- 크누스 최적화

---

# 풀이
```kotlin
fun main() {
    var t = i()
    val sb = StringBuilder()
    var n: Int
    val a = IntArray(5001)

    val d = Array(5001) { IntArray(5001) }
    val s = IntArray(5001)
    val opt = Array(5001){IntArray(5001)}
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
- 크누스 최적화 + 다이나믹 프로그래밍을 통해 문제를 해결했다.
- `dp[i][j]` 는 i+1번 파일부터 j번 파일까지 합치는데 필요한 최소 비용이다.
- `opt[i][j]` 는 i+1번 파일부터 j번 파일까지 합칠 때, `dp[i][j]` 가 최소가 되도록 하는 k를 저장한다

---
