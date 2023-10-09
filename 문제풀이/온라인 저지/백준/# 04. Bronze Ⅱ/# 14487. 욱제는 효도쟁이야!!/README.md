# 문제
- 플랫폼 : 백준
- 번호 : 14487
- 제목 : 욱제는 효도쟁이야!!
- 난이도 : Bronze 2
- 모든 마을을 관광하기 위해 필요한 최소 이동비용을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14487" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var n = i()
    var s = 0
    var m = 0
    while (n --> 0) i().also { s += it; if (it > m) m = it}
    s -= m
    writeInt(s)
    flushBuffer()
}
```
- 모든 마을을 관광하려면 시계방향으로 이동하거나, 반시계방향으로 이동해야한다.
- 그런데 시작점을 잘 정해야한다. 간선의 길이가 가장 긴 경로를 통행하지 않으면 최소 비용으로 통행할 수 있다.

---
