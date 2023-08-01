# 문제
- 플랫폼 : 백준
- 번호 : 15894
- 제목 : 수학은 체육과목 입니다
- 난이도 : Bronze 3
- 가장 아랫부분의 정사각형이 n개가 되었을 때, 실선으로 이루어진 도형의 둘레의 길이를 구하시오
- 문제 : <a href="https://www.acmicpc.net/problem/15894" target="_blank">링크</a>

---

# 필요 지식
- 기

---

# 풀이
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = br.readLine().toLong() * 4
    print(answer)
}
```
- 규칙성을 파악해보면 n의 4배이다

---
