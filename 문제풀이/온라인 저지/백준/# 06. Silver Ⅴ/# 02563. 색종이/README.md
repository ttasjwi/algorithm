# 문제
- 플랫폼 : 백준
- 번호 : 02563
- 제목 : 색종이
- 난이도 : Silver 5
- 첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/2563" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val count = readInt()
    val isBlack = Array(100) { BooleanArray(100) }

    var x1: Int
    var y1: Int
    repeat(count) {
        x1 = readInt()
        y1 = readInt()
        for (y in y1 until y1 + 10) {
            for (x in x1 until x1 + 10) {
                isBlack[y][x] = true
            }
        }
    }
    var answer = 0
    for (x in 0..99) {
        for (y in 0..99) {
            if (isBlack[y][x]) answer++
        }
    }
    print(answer)
}
```
- 도화지의 왼쪽맨아래 시작점을 (0,0) 으로 보고 주어진 문제상황을 좌표평면으로 해석한다.
  - 좌표평면의 특정 한칸의 색칠 상태를 체크하는 관점에서 볼 때 이차원 배열로 풀어야한다.
- 떨어진 거리를 각각 x1, y1으로 받고, 해당 지점부터 가로 세로 10칸 영역을 전부 색칠된 영역으로 만든다.
- 최종적으로 색칠된 부분의 갯수를 세서 출력한다.

---
