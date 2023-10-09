# 문제
- 플랫폼 : 백준
- 번호 : 05585
- 제목 : 거스름돈
- 난이도 : Bronze 2
- 잔돈에 포함된 매수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5585" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var m = 1000 - i()
    var answer = 0
    val units = intArrayOf(500, 100, 50, 10, 5, 1)
    var tmp: Int
    for (unit in units) {
        tmp = m/unit
        if (tmp > 0) {
            answer += tmp
            m %= unit
            if (m == 0) break
        }
    }
    writeInt(answer)
    flushBuffer()
}
```
- 1000엔에서 구입액만큼 차감한 뒤 거스름돈을 구해야한다.
- 이 때 큰 단위로 거슬러줄 수록 지급할 잔돈의 매수가 줄어든다.

---
