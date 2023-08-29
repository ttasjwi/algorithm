# 문제
- 플랫폼 : 백준
- 번호 : 09461
- 제목 : 파도반 수열
- 난이도 : Silver 3
- 각 테스트 케이스마다 P(N)을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9461" target="_blank">링크</a>

---

# 필요 알고리즘
- DP(다이나믹 프로그래밍)

---

# 풀이
```kotlin
fun main() {
    val p = LongArray(101)
    p[1] = 1
    p[2] = 1
    p[3] = 1
    p[4] = 2
    p[5] = 2

    for (i in 6..100) {
        p[i] = p [i-5] + p[i-1]
    }
    var t = i()
    val sb = StringBuilder()
    while (t-- > 0) {
        sb.append(p[i()]).append('\n')
    }
    print(sb)
}
```
- 5번째 수까지는 규칙을 안 따르지만, 6번째 수부터는 주기적으로 규칙이 반복된다.
- 6번째 수부터는, `p[i] = p[i-1] + p[i-5]`가 반복된다.
```kotlin
fun main() {
    val p = LongArray(101)
    p[1] = 1
    p[2] = 1
    p[3] = 1
    p[4] = 2
    p[5] = 2

    for (i in 6..100) {
        p[i] = p [i-5] + p[i-1]
    }
    var t = i()
    val sb = StringBuilder()
    while (t-- > 0) {
        sb.append(p[i()]).append('\n')
    }
    print(sb)
}
```
- 풀고나서 보니 `p[i-2] + p[i-3]` 도 먹힌다...

---
