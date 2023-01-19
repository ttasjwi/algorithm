# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120898
- 제목 : 편지
- 난이도 : Level 0
- message를 적기 위해 필요한 편지지의 최소 가로길이를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120898)

---

# 필요 알고리즘
- 문자열 길이 반환함수만 알면 됨

---

# Python
```python
def solution(message):
    return len(message) * 2;

```

---

# Java
```java
public class Solution {
    public int solution(String message) {
        return message.length() * 2;
    }
}
```

---
