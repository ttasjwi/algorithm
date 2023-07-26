# 문제
- 플랫폼 : 백준
- 번호 : 10998
- 제목 : A×B
- 난이도 : Bronze 5
- A×B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10998" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이

## Kotlin
```kotlin
fun main() {
    val a = System.`in`.read() - 48
    System.`in`.read()
    val b = System.`in`.read() - 48
    print(a*b)
}
```

## Python
```python
a, b = map(int, input().split())
answer = a * b
print(answer, end='')
```

---
