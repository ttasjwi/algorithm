# 문제
- 플랫폼 : 백준
- 번호 : 24263
- 제목 : 알고리즘 수업 - 알고리즘의 수행 시간 2
- 난이도 : Bronze 4
- 코드의 수행횟수 및 수행 횟수를 다항식으로 표현했을 때의 최고차항 차수 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24263" target="_blank">링크</a>

---

# 필요 지식
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val sb = StringBuilder()
    sb.append(readInt()).append('\n').append('1')
    print(sb)
}
```
- 주어진 문제상황은 1부터 n까지 반복해서 `#코드1`을 반복수행하는 상황이다.
- 수행 횟수는 n회이고, n에 비례하여 알고리즘이 수행되므로 시간 복잡도는 `O(n)`이다. 이 경우 최고차항의 차수는 1이다.

---
