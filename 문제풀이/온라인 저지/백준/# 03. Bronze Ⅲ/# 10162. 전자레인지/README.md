# 문제
- 플랫폼 : 백준
- 번호 : 10162
- 제목 : 전자레인지
- 난이도 : Bronze 3
- T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10162" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val units = intArrayOf(300, 60, 10)
    val results = IntArray(3)
    for (i in 0 until 3) n %= units[i].also { results[i] = n/units[i] }
    if (n > 0) writeInt(-1)
    else for (result in results) writeInt(result)
    flushBuffer()
}
```
- 가능한 적은 버튼을 누르려면 가능한 큰 단위의 버튼을 우선적으로 누르면 된다.
- 최종적으로 남은 n이 0보다 크면 -1 을 출력, 그렇지 않다면 각 버튼을 누른 횟수를 순차적으로 출력하면 된다.
---
