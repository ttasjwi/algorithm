# 문제
- 플랫폼 : 백준
- 번호 : 17826
- 제목 : 나의 학점은?
- 난이도 : Bronze 2
- 첫째 줄에 홍익이의 학점을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17826" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    val ranks = IntArray(301)
    for (i in 1..50) ranks[i()] = i
    writeStr(
        when (ranks[i()]) {
            in 1..5 -> "A+"
            in 6..15 -> "A0"
            in 16..30 -> "B+"
            in 31..35 -> "B0"
            in 36..45 -> "C+"
            in 46..48 -> "C0"
            else -> "F"
        }
    )
    flushBuffer()
}
```
- 301칸 배열 선언 후 입력하는 족족 각 값에 등수를 저장
- 다음 줄에 들어온 점수가 가리키는 위치에 어떤 등수가 저장되있는 지 조회 후 출력

---
