# 문제
- 플랫폼 : 백준
- 번호 : 10815
- 제목 : 숫자 카드
- 난이도 : Silver 5
- 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10815" target="_blank">링크</a>

---

# 필요 지식
- 카운팅

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val cards = BooleanArray(20_000_001)
    while (n -- > 0) {
        cards[i() + 10_000_000] = true
    }
    var m = i()
    val sb = StringBuilder()
    while (m -- > 0) {
        sb.append(if (cards[i() + 10_000_000]) 1 else 0).append('\n')
    }
    print(sb)
}
```
- 카운터를 두고 한번이라도 등장하면 true 플래그
- 이후 입력 받을 때마다 카운터에 해당 요소가 true인지 확인후 출력

---
