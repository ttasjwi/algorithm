# 문제
- 플랫폼 : 백준
- 번호 : 16944
- 제목 : 강력한 비밀번호
- 난이도 : Bronze 2
- 리듬 테트리스의 비밀번호 규칙을 지키기 위해 추가해야 하는 문자의 최소 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/16944" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var low = false
    var up = false
    var num = false
    var spec = false

    var cur: Byte
    repeat(n) {
        cur = r()
        when (cur) {
            in 48..57 -> {num = true }
            in 97..122 -> { low = true }
            in 65..90 -> { up = true }
            else -> { spec = true }
        }
    }
    r()
    var answer = 0
    if (!num) answer++
    if (!low) answer++
    if (!up) answer++
    if (!spec) answer++
    if (answer + n < 6) {
        answer = 6 - n
    }
    writeInt(answer)
    flushBuffer()
}
```
- 문자를 읽어가며 숫자, 소문자, 대문자, 특수문자의 등장 여부를 체크한다.
- 등장하지 않은 것만큼 answer를 증가시킨다.
- 이때, answer와 원본 문자열 길이 합이 6 이상인 경우는 문제가 없다. 하지만 answer에 문자열 길이를 합한 값이 6보다 작은 경우는
추가적으로 아무 문자를 넣어야한다. 이 경우 6에서 n을 뺀 값만큼만 정해진 규칙에 따라 지정 문자를 섞기만 하면 규칙을 만족시키므로 6-n으로 answer를 대체한다.

---
