# 문제
- 플랫폼 : 백준
- 번호 : 11651
- 제목 : 좌표 정렬하기 2
- 난이도 : Silver 5
- 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11651" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이

```kotlin
import kotlin.Comparable

fun main() {
    val points = Array(readInt()) { Point(readInt(), readInt()) }
    points.sort()
    val sb = StringBuilder()
    for (point in points) {
        sb.append(point.x).append(' ').append(point.y).append('\n')
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}

data class Point(
    val x: Int,
    val y: Int
) : Comparable<Point> {

    override fun compareTo(other: Point) = if (y == other.y) x - other.x else y - other.y

}
```
- Point 클래스 생성 후 Comparable을 구현
- 이를 이용해 정렬

---
