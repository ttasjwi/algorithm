# 문제
- 플랫폼 : 백준
- 번호 : 02745
- 제목 : 진법 변환
- 난이도 : Bronze 2
- B진법 수 N을 10진법으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2745" target="_blank">링크</a>

---

# 필요 지식
- 진법

---

# 풀이
## Kotlin
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken()
    val b = st.nextToken().toInt()
    var answer = 0
    for (ch in n) {
        answer = answer * b + (if (ch.isDigit()) ch - '0' else ch - 'A' + 10)
    }
    print(answer)
}
```
- 첫번째 자리부터 순서대로 문자를 읽고, 이전 자리까지의 숫자 합에 b를 곱해나간다.
- 이렇게하면 역방향으로 지수 계산을 하지 않고 진법 변환을 할 수 있다.

---
