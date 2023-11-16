# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181842
- 제목 : 부분 문자열
- 난이도 : Level 0
- str1이 str2에 포함되면 1 아니면 0을 출력
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181842" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
class Solution {
    fun solution(str1: String, str2: String): Int {
        return if (str2.contains(str1)) 1 else 0
    }
}
```
- contains 메서드 사용