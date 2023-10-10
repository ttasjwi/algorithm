# 문제
- 플랫폼 : 백준
- 번호 : 21313
- 제목 : 문어
- 난이도 : Bronze 2
- 수열을 이루는 숫자들을 순서대로 공백으로 구분하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/21313" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    val n = i()
    repeat(n/2) {
        writeByte(49)
        writeByte(ASCII_space)
        writeByte(50)
        writeByte(ASCII_space)
    }
    if (n%2 == 1) writeByte(51)
    flushBuffer()
}
```
- 1,2,1,2,1,2 순으로 악수하면 된다
- 그런데 문어 수가 홀수이면 마지막엔 3번째 손으로 악수해야한다.
  - 1,2,1,2,1 이면 첫번째 문어가 이미 1로 악수하고 있기 때문이다.

---
