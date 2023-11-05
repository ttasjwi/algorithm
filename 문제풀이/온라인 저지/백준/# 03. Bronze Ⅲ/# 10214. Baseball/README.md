# 문제
- 플랫폼 : 백준
- 번호 : 10214
- 제목 : Baseball
- 난이도 : Bronze 3
- 각각의 케이스마다 한 줄에 연세대가 이겼을 경우 "Yonsei", 고려대가 이겼을 경우 "Korea", 비겼을 경우 "Draw"를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10214" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```kotlin
fun main() {
    val t = i()
    var y: Int
    var k: Int
    repeat(t) {
        y = 0
        k = 0
        repeat(9) {
            y += i()
            k += i()
        }
        writeStr(
            when {
                (y>k) -> "Yonsei"
                (y<k) -> "Korea"
                else -> "Draw"
            }
        )
        writeByte(ASCII_n)
    }
    flushBuffer()
}
```
- 시키는 대로 하면 됨

---
