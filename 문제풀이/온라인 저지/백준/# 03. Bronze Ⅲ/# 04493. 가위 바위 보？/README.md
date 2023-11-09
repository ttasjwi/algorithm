# 문제
- 플랫폼 : 백준
- 번호 : 04493
- 제목 : 가위 바위 보 ?
- 난이도 : Bronze 3
- 각 테스트 케이스에 대해서 승자를 출력한다. (Player 1 또는 Player 2) 만약, 비겼을 경우에는 TIE를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4493" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
private const val R: Byte = 82
private const val P: Byte = 80

fun main() {
    var t = i()
    while (t-- > 0) {
        var n = i()
        var s1 = 0
        var s2 = 0
        while (n -- > 0) {
            val p1 = r()
            r()
            val p2 = r()
            r()

            if (p1 == p2) continue
            else if (p1 == R) {
                if (p2 == P) {
                    s2 ++
                } else {
                    s1 ++
                }
            } else if (p1 == P) {
                if (p2 == R) {
                    s1 ++
                } else {
                    s2 ++
                }
            } else {
                if (p2 == R) {
                    s2 ++
                } else {
                    s1 ++
                }
            }
        }
        if (s1 == s2) {
            writeStr("TIE\n")
        } else if (s1 > s2) {
            writeStr("Player 1\n")
        } else {
            writeStr("Player 2\n")
        }
    }
    flushBuffer()
}
```
- 매순간 문자를 비교하고 그 결과에 따라 점수를 계산한다.
- 각 테스트 케이스별, 점수 비교 결과를 출력한다.
- 정말 시키는대로 하면 되는 문제

---
