# 문제
- 플랫폼 : 백준
- 번호 : 10869
- 제목 : 사칙연산
- 난이도 : Bronze 5
- 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10869" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이

## Kotlin
```kotlin
fun main() {
    val a = readInt()
    val b = readInt()
    val sb = StringBuilder()
    sb.append(a+b)
        .append('\n')
        .append(a-b)
        .append('\n')
        .append(a*b)
        .append('\n')
        .append(a/b)
        .append('\n')
        .append(a%b)
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}
```

---

## Python
```python
a, b = map(int, input().split())
answer = '\n'.join([
    str(a + b),
    str(a - b),
    str(a * b),
    str(a // b),
    str(a % b)
])
print(answer, end='')

```

---
