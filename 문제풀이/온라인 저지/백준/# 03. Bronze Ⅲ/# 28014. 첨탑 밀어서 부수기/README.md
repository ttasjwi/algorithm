# 문제
- 플랫폼 : 백준
- 번호 : 28014
- 제목 : 첨탑 밀어서 부수기
- 난이도 : Bronze 3
- 첨탑을 밀어야 하는 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/28014" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    var n = i() - 1
    var cnt = 1
    var before = i()
    var cur: Int
    while (n -- > 0) {
        cur = i()
        if (cur >= before) cnt ++
        before = cur
    }
    writeInt(cnt)
    flushBuffer()
}
```
- 단순히 연산하는 문제
- 첨탑을 매번 확인하면서 이전보다 크거나 같으면 밀어야하는 횟수를 증가시킨다.

---
