# 문제
- 플랫폼 : 백준
- 번호 : 24266
- 제목 : 알고리즘 수업 - 알고리즘의 수행 시간 5
- 난이도 : Bronze 3
- 첫째 줄에 코드1 의 수행 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24266" target="_blank">링크</a>

---

# 필요 지식
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val n = readLong()
    val sb = StringBuilder()
    sb.append(n * n * n).append('\n').append('3')
    print(sb)
}
```
- 단순 3중 for문.
- 시간복잡도 : O(N^3)