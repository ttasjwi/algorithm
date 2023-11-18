# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181849
- 제목 : 문자열 정수의 합
- 난이도 : Level 0
- 각 자리 숫자의 합 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181849" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
class Solution {
    fun solution(num_str: String): Int {
        var answer = 0
        for (ch in num_str) {
            answer += (ch.code - 48)
        }
        return answer
    }
}
```
- `문자.code`는 문자의 코드값을 반환한다.
- 0,1,2,...9의 아스키 코드는 48,49,...57 이다.

---
