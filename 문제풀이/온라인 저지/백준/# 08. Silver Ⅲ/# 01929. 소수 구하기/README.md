# 문제
- 플랫폼 : 백준
- 번호 : 01929
- 제목 : 소수 구하기
- 난이도 : Silver 3
- m 이상 n 이하 소수를 모두 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1929" target="_blank">링크</a>

---

# 필요 지식
- 에라토스테네스의 체

---

# 풀이
```kotlin
import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    val m = i()
    val n = i()

    val check = BooleanArray(n+1)
    check[0] = true
    check[1] = true

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2*i..n step i) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    for (i in m..n) {
        if (!check[i]) {
            sb.append(i).append('\n')
        }
    }
    print(sb)
}
```
- n 이하의 소수를 모두 구하기(에라토스테네스의 체)
- m 이상 n 이하의 소수를 하나씩 출력
---
