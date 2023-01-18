# Programmers 120825 : 문자 반복 출력하기
- 난이도 : Level 0
- my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120825)

---

## 풀이
```java
public class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();

        for (char ch : my_string.toCharArray()) {
            for (int i=0; i<n; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
```

---
