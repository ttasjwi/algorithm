# 문제
- 플랫폼 : 백준
- 번호 : 02903
- 제목 : 중앙 이동 알고리즘
- 난이도 : Bronze 3
- 과정을 N번 거친 후 점의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2903" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = (2 shl n - 1) + 1 // 2의 n제곱 + 1
    print(m * m)
}
```
- 1회 -> (2^1 + 1)^2 = 9
- 2회 -> (2^4 + 1)^2 = 25
- 3회 -> (2^3 + 1)^2 = 81
- ...
- n회 -> (2^n +1)^2
- 2의 거듭제곱 꼴을 구할 떄 shl 연산자를 사용하면 편리하다.
  - shl : 비트를 왼쪽으로 민다 -> 한칸 밀 때마다 두 배가 됨

---
