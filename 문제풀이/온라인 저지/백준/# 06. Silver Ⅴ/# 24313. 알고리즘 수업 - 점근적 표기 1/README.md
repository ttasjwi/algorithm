# 문제
- 플랫폼 : 백준
- 번호 : 24313
- 제목 : 알고리즘 수업 - 점근적 표기 1
- 난이도 : Silver 5
- f(n), c, n0가 O(n) 정의를 만족하면 1, 아니면 0을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24313" target="_blank">링크</a>

---

# 필요 지식
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val a1 = readInt()
    val a0 = readInt()
    val c = readInt()
    val n0 = readInt()

    print(if (a1 <= c && (a1 - c) * n0 + a0 <= 0) 1 else 0)
}
```
- 모든 n >= n0인 n에 대해 f(n) >= g(n) 이어야한다
- 일차함수 그래프로 놓고봤을 때 기울기 `a1 <= c` 여야 하고, 시작점인 n0 시점에서부터 `f(n0) >= g(n0)` 여야한다.

---
