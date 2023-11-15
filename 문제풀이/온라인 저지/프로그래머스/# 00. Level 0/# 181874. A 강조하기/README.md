# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181874
- 제목 : A 강조하기
- 난이도 : Level 0
- 알파벳 "a"가 등장하면 전부 "A"로 변환하고, "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181874" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이

## 풀이1
```kotlin
class Solution {
    fun solution(myString: String): String {
        val sb = StringBuilder()
        for (ch in myString) {
            if (ch == 'a') {
                sb.append('A')
            } else if (ch in 'B'..'Z') {
                sb.append((ch.code + 32).toChar())
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }
}
```
- 문자 하나하나 순서대로 StringBuilder를 통해 새로 만들어가는게 가장 시간복잡도 면에서 효율적이라 판단하였다.
- 문자가 'a'  이면 'A'를 붙이고, 문자가 'B'..'Z'이면 소문자화 하며, 나머지는 그대로 붙이면 된다.
- 0.04~0.05ms 정도 소요

## 풀이2
```kotlin
class Solution {
    fun solution(myString: String) = myString.lowercase().replace("a", "A")
}
```
- 모두 소문자화 시키고 'a'를 'A'로 모두 대체한다.
- 표현은 더 간결하지만 전체 순회하면서 수정하는 연산을 두번 수행하므로 성능상으로는 더 안 좋을 듯.
- 6.85ms ~ 13.01ms 소요

---
