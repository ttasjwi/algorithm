# 문제
- 플랫폼 : 백준
- 번호 : 30018
- 제목 : 타슈
- 난이도 : Bronze 3
- 각 대여소에 위치한 자전거의 개수를 a1... an으로 만들기 위해서 자전거를 최소 몇 번 옮겨야하는 지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/30018" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val a = IntArray(n) { i() }
    var answer = 0
    for (i in 0 until n) {
        answer += (a[i] - i()).let { if (it > 0) it else 0 }
    }
    writeInt(answer)
    flushBuffer()
}
```
- `a[i]`, `b[i]` 를 비교했을 때 `b[i]`가 과잉인 경우 과잉인 양만큼 cnt에 가산

---
