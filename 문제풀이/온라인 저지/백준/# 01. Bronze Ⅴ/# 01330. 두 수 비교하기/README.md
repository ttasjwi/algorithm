# 문제
- 플랫폼 : 백준
- 번호 : 01330
- 제목 : 두 수 비교하기
- 난이도 : Bronze 5
- A와 B를 비교
- 문제 : <a href="https://www.acmicpc.net/problem/1330" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# Python
```python
def main():
    a, b = map(int, input().split())
    answer = solution(a,b)
    print(answer, end='')


def solution(a, b):
    if a > b:
        return '>'
    elif a < b:
        return '<'
    else:
        return '=='


main()

```
- a, b 를 입력 받는다.
- solution 함수를 호출하여 비교 문자열을 얻는다.
- 결과를 출력한다.

---

# Kotlin
```kotlin
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    print(
        when {
            a > b -> ">"
            a < b -> "<"
            else -> "=="
        }
    )
}
```

---
