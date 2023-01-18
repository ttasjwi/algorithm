# Programmers 120826 : 특정 문자 제거하기
- 난이도 : Level 0
- my_string에서 letter를 제거한 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120826)

---

## 풀이
```java
public class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter,"");
    }
}
```

---
