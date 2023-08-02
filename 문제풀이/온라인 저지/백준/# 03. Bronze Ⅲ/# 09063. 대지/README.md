# 문제
- 플랫폼 : 백준
- 번호 : 09063
- 제목 : 대지
- 난이도 : Bronze 3
- 첫째 줄에 N 개의 점을 둘러싸는 최소 크기의 직사각형의 넓이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9063" target="_blank">링크</a>

---

# 필요 지식
- 기

---

# 풀이
```kotlin
fun main() {
    var n = readInt()
    var minX = 10001
    var minY = 10001
    var maxX = -10001
    var maxY = -10001
    var x: Int
    var y: Int
    while (n-- > 0) {
        x = readInt()
        y = readInt()

        if (x < minX) minX = x
        if (x > maxX) maxX = x
        if (y < minY) minY = y
        if (y > maxY) maxY = y
    }
    print((maxX - minX) * (maxY - minY))
}
```
- x, y의 최대, 최소를 매 순간 갱신시킨다.
- `(x의 최대- 최소) * (y의 최대 - 최소)`가 문제에서 구하는 답이다.

---
