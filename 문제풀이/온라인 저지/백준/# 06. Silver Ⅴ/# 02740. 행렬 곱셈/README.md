# 문제
- 플랫폼 : 백준
- 번호 : 02740
- 제목 : 행렬 곱셈
- 난이도 : Silver 5
- 첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2740" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val a = Array(n){IntArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            a[i][j] = i()
        }
    }
    i()
    val k = i()
    val b = Array(m){IntArray(k)}
    for (i in 0 until m) {
        for (j in 0 until k) {
            b[i][j] = i()
        }
    }
    val sb = StringBuilder()
    var tmp: Int
    for (t in 0 until n) {
        for (u in 0 until k) {
            tmp = 0
            for (v in 0 until m) {
                tmp += a[t][v] * b[v][u]
            }
            sb.append(tmp).append(' ')
        }
        sb.append('\n')
    }
    print(sb)
}
```
- 행렬의 곱셈을 수행

---
