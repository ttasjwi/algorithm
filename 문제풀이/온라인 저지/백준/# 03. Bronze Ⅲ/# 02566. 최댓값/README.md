# 문제
- 플랫폼 : 백준
- 번호 : 02566
- 제목 : 최댓값
- 난이도 : Bronze 3
- 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2566" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
import java.lang.StringBuilder

fun main() {
    var current: Int
    var maxValue = -1
    var maxColumn = 0
    var maxRow = 0

    loop@for (r in 1..9) {
        for (c in 1..9) {
            current = readInt()
            if (maxValue < current) {
                maxValue = current
                maxColumn = c
                maxRow = r
                if (current == 99) break@loop
            }
        }
    }
    val sb = StringBuilder()
    sb.append(maxValue)
        .append('\n')
        .append(maxRow).append(' ').append(maxColumn)
    print(sb)
}
```
- loop를 반복돌리는데, 현재 값이 제일 크면 최대값,행,열을 모두 갱신한다.
  - 현재값이 99면 2중 for문 자체를 탈출한다.
- 출력

---
