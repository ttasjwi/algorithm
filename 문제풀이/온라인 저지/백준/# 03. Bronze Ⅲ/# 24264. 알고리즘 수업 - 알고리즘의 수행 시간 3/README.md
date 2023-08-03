# 문제
- 플랫폼 : 백준
- 번호 : 24264
- 제목 : 알고리즘 수업 - 알고리즘의 수행 시간 3
- 난이도 : Bronze 3
- 첫째 줄에 코드1 의 수행 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24264" target="_blank">링크</a>

---

# 필요 알고리즘
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val n = readLong()
    val sb = StringBuilder()
    sb.append(n * n).append('\n').append('2')
    print(sb)
}

```
- 2중 for문을 도는데 n^2회 반복한다.
- 시간복잡도는 O(n^2) 이고, 차수는 2이다

---
