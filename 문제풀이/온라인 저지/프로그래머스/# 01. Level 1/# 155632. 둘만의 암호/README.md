# 문제
- 플랫폼 : 프로그래머스
- 번호 : 155632
- 제목 : 둘만의 암호
- 난이도 : Level 1
- 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꾼 결과 문자열을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/155652" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val nexts = "abcdefghijklmnopqrstuvwxyz".replace("[$skip]".toRegex(), "")
        val sb = StringBuilder()
        val charReplace = CharArray(26)
        for (i in nexts.indices) {
            charReplace[nexts[i].code - 97] = nexts[(i + index + nexts.length)%nexts.length]
        }

        for (ch in s) sb.append(charReplace[ch.code -97])
        return sb.toString()
    }
}
```
- "abcd...z"에서 `"[$skip]".toRegex()` 패턴을 `""` 으로 대체한 것을 nexts에 할당한다.
- nexts의 각 문자마다, index 만큼 증가시킨 위치의 문자를 charReplace 배열에 할당한다.
- s의 각 문자를 charReplace 배열에서 대체 문자를 찾아 대체하여 sb에 append
- sb.toString 반환
