# 문제
- 플랫폼 : 백준
- 번호 : 04948
- 제목 : 베르트랑 공준
- 난이도 : Silver 2
- 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4948" target="_blank">링크</a>

---

# 필요 지식
- 에라토스테네스의 체

---

# 풀이
```kotlin
fun main() {
    val m = 246912
    val check = BooleanArray(m+1)
    check[0] = true
    check[1] = true
    val count = IntArray(m+1)
    for (i in 2..sqrt(m.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2*i .. m step i) {
                check[j] = true
            }
        }
    }
    for (i in 1..m) {
        count[i] = if (!check[i]) count[i-1] + 1 else count[i-1]
    }
    var n: Int
    val sb = StringBuilder()
    while (true) {
        n = i()
        if (n == 0) {
            break
        }
        sb.append(count[2*n] - count[n]).append('\n')
    }
    print(sb)
}
```
- 246912까지 소수 판별을 한다
- 각 숫자까지의 소수 갯수를 캐싱한다
- n 초과 2n 이하 범위에서, 소수의 개수를 구하려면 2n까즤의 소수 갯수에서 n까지의 소수갯수를 빼면 된다

---
