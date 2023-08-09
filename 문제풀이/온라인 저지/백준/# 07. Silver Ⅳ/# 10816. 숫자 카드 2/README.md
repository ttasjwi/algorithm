# 문제
- 플랫폼 : 백준
- 번호 : 10816
- 제목 : 숫자 카드 2
- 난이도 : Silver 4
- 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10816" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    val counter = IntArray(20_000_001)
    var n = i()
    while (n-- > 0) {
        counter[i() + 10_000_000]++
    }
    var m = i()
    val sb = StringBuilder()
    while (m-- > 0) {
        sb.append(counter[i() + 10_000_000]).append(' ')
    }
    print(sb)
}
```
- 카운터로 카운팅
- 이후 들어온 라인의 각 요소를 카운터에서 찾아 그 숫자를 순서대로 출력

---
