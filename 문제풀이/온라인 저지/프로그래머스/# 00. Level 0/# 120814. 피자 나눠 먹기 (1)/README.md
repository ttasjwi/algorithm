# Programmers 120814 : 피자 나눠 먹기 (1)
- 난이도 : Level 0
- 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120814)

---

## 풀이
```java
public class Solution {

    public int solution(int n) {
        int share = n/7;
        int remainder = n%7;

        return (remainder > 0) ? share + 1 : share;
    }
}
```
- 사람 수를 7로 나눴을 때, 나누어 7로 떨어진다면 딱 그 몫만큼 피자를 주문하면 된다.
- 7로 나누어 떨어지지 않는다면, 몫에 1만큼 더 하여 그만큼 피자를 주문하면 된다.

---
