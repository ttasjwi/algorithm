# Programmers 120809 : 배열 두 배 만들기
- 난이도 : Level 0
- 주어진 배열의 각 숫자를 2배로 한 배열 반환
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120809)

---

## 풀이
```java
public class Solution {
    public int[] solution(int[] numbers) {
        for (int i=0; i< numbers.length; i++) {
            numbers[i] = 2 * numbers[i];
        }
        return numbers;
    }
}
```

---
