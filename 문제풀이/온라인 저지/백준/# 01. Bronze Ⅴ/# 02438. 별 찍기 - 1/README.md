# 문제
- 플랫폼 : 백준
- 번호 : 02438
- 제목 : 별 찍기 - 1
- 난이도 : Bronze 5
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2438" target="_blank">링크</a>

---

# 필요 지식
- 반복문

---

# 풀이
## Python
```python
n = int(input())

answer = '\n'.join('*' * (i+1) for i in range(n))
print(answer)
```

## Kotlin
```kotlin
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val st = StringTokenizer(readln())
    val sb = StringBuilder()
    for (i in 1..st.nextToken().toInt()) {
        repeat(i) {
            sb.append('*')
        }
        sb.append('\n')
    }
    print(sb)
}
```

---
