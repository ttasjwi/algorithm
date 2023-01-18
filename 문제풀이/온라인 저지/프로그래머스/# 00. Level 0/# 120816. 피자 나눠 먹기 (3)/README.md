# Programmers 120816 : 피자 나눠 먹기 (3)
- 난이도 : Level 0
- 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때, n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를
시켜야 하는지
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120816)

---

## 풀이
```java
public class Solution {
    public int solution(int slice, int n) {
        int share = n/slice;
        int remainder = n%slice;
        return (remainder > 0) ? share + 1 : share;
    }
}
```
