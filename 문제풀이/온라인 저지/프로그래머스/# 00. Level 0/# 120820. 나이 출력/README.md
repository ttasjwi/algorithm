# Programmers 120820 : 나이 출력
- 난이도 : Level 0
- 나이 age가 주어질 때, 2022년 기준 출생 연도
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120820)

---

## 풀이
```java
public class Solution {

    private static final int STANDARD_YEAR = 2022;

    public int solution(int age) {
        return STANDARD_YEAR - age + 1;
    }
}
```

---
