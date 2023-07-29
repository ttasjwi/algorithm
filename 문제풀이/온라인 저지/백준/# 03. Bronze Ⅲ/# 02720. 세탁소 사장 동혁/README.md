# 문제
- 플랫폼 : 백준
- 번호 : 02720
- 제목 : 세탁소 사장 동혁
- 난이도 : Bronze 3
- 필요한 쿼터의 개수, 다임의 개수, 니켈의 개수, 페니의 개수를 공백으로 구분하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2720" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
## Kotlin
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var c: Int
    val units = intArrayOf(25, 10, 5, 1)
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        c = br.readLine().toInt()

        for (unit in units) {
            sb.append(c/unit)
            sb.append(' ')
            c %= unit
        }
        sb.append('\n')
    }
    print(sb)
}
```
- 그리디 알고리즘의 대표적인 유형인 동전 교환문제이다.
- 25,10,5,1 순으로 나눈 몫만큼 거스름돈을 교환해나가면 된다.

---
