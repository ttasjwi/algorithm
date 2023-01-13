# 문제
- 번호 : 120849
- 제목 : 모음 제거
- 난이도 : Level 0
- 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120849)

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```java
public class Solution {

    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }
}
```
- replaceAll에서 인자로 정규표현식을 넘기면, 만족하는 모든 문자열을 원하는 문자열로 변환할 수 있다.

---
