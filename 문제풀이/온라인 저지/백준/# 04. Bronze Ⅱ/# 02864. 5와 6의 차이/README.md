# 문제
- 플랫폼 : 백준
- 번호 : 02864
- 제목 : 5와 6의 차이
- 난이도 : Bronze 2
- 첫째 줄에 상근이가 구할 수 있는 두 수의 합 중 최솟값과 최댓값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2864" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    val a = i()
    val b = i()
    writeInt(a[0] + b[0])
    writeInt(a[1] + b[1])
    flushBuffer()
}

private fun i(): IntArray {
    var min = 0
    var max = 0
    var c: Int
    while (isDigit(r().also { c = it.toInt() })) {
        min = min * 10 + if (c == 54) 5 else c - 48
        max = max * 10 + if (c == 53) 6 else c - 48
    }
    return intArrayOf(min, max)
}
```
- 입력을 받는 단계에서 배열로 받았다.
- 5 또는 6이 들어왔을 때 변형을 가한다.
- 최소끼리는 최소끼리 최대끼리는 최대끼리 합한다.

---
