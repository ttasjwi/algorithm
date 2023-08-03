# 문제
- 플랫폼 : 백준
- 번호 : 24265
- 제목 : 알고리즘 수업 - 알고리즘의 수행 시간 4
- 난이도 : Bronze 3
- 첫째 줄에 코드1 의 수행 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24265" target="_blank">링크</a>

---

# 필요 지식
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val n = readLong()
    val sb = StringBuilder()
    sb.append(n * (n-1)/2).append('\n').append('2')
    print(sb)
}
```
- i = 1 -> (n-1)회
- i = 2 -> (n-2)회
- ...
- i = n-1 -> 1 회
- 총 n(n-1)/2 회 반복한다.
- 시간복잡도는 O(n^2)이다

---
