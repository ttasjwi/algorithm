# 문제
- 플랫폼 : 백준
- 번호 : 11005
- 제목 : 진법 변환2
- 난이도 : Bronze 1
- 첫째 줄에 10진법 수 N을 B진법으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11005" target="_blank">링크</a>

---

# 필요 지식
- 진법

---

# 풀이
```kotlin
import java.lang.StringBuilder

fun main() {
    var n = readInt()
    val b = readInt()
    val sb = StringBuilder()
    var tmp: Int
    while (n >= b) {
        tmp = n % b
        sb.append(toNumberChar(tmp))
        n /= b
    }
    sb.append(toNumberChar(n))
    print(sb.reverse())
}

private fun toNumberChar(value: Int): Char {
    return if (value < 10) (value + 48).toChar()
           else (value + 55).toChar()
}
```
- 10진법 수를 반복해서 진수로 나눴을 때, 그 때마다 나오는 나머지를 역순으로 이어붙이면 b진법의 숫자가 된다.
- 10보다 작은 경우는 십진 표현법으로 나타낼 수 있고, 10이상인 경우 55를 더하여 A,B,C, ... 순으로 나타낼 수 있다.
  - 아스키코드에서 65는 'A'이다

---
