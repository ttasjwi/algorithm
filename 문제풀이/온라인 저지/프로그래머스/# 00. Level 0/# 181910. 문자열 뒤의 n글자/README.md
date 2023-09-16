# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181910
- 제목 : 문자열의 뒤의 n글자
- 난이도 : Level 0
- my_string의 뒤의 n글자로 이루어진 문자열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181910" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
class Solution {
    fun solution(my_string: String, n: Int): String = my_string.substring(my_string.length -n)
}
```
- substring으로 마지막 n글자를 추출한다

---
