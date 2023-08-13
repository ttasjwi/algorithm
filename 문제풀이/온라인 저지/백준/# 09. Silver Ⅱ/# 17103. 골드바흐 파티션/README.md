# 문제
- 플랫폼 : 백준
- 번호 : 17103
- 제목 : 골드바흐 파티션
- 난이도 : Silver 2
- 각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17103" target="_blank">링크</a>

---

# 필요 지식
- 에라토스테네스의 체

---

# 풀이
```kotlin
import kotlin.math.sqrt

fun main() {
    var t = i()
    val m = 1_000_000
    val check = BooleanArray(m + 1)
    check[0] = true; check[1] = true
    for (i in 2..sqrt(m.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2 * i..m step i) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    var cnt: Int
    var n: Int
    while (t-- > 0) {
        n = i()
        cnt = 0
        for (i in 2..n / 2) {
            if (!check[i] && !check[n - i]) {
                cnt ++
            }
        }
        sb.append(cnt).append('\n')
    }
    print(sb)
}
```
- 100만까지의 소수를 모두 찾는다. (에라토스테네스의 체)
- 이후, n 입력이 들어올 때마다, 2부터 n/2 까지 i를 순회하면서 n에서 i를 뺀 값의 요소가 소수인지 확인한다. 소수이면, 카운팅한다
- 카운팅 결과를 StringBuilder 에 append 한다.

---
