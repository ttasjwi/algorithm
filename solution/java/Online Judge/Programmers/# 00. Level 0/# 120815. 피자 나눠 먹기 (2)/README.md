# Programmers 120815 : 피자 나눠 먹기 (2)
- 난이도 : Level 0
- n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120815)

---

## 풀이1
```java
public class Solution1 {
    public int solution(int n) {
        int answer = 1;
        while (true) {
            if (6 * answer % n == 0) {
                break;
            }
            answer ++;
        }
        return answer;
    }
}
```
- 피자 한 판당 6조각이므로 사람 수를 answer라 할 때, 총 피자 조각 수는 6 * answer 조각이다.
- 전체 피자 조각수가 사람 수로 나누어 떨어질 때까지 answer 값을 증가시킨다.
- 여기서 얻어낸 answer 값이 정답이다.

---

## 풀이2
```java
public class Solution {
    public int solution(int n) {
        return lcm(n, 6) / 6;
    }

    public int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int r = max % min;

        return (r == 0)
                ? min
                : gcd(min, r);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
```
- 1명이 남기지 않고 피자를 먹으려면 6조각이 필요하다.
- 2명이 남기지 않고 피자를 먹으려면 6조각이 필요하다.
- 4명이 남기지 않고 피자를 먹으려면 12조각이 필요하다.
- 5명이 남기지 않고 피자를 먹으려면 30조각이 필요하다.
- 여기서 유추할 수 있는 것은, n명이 피자를 남기지 않으려면 n과 6의 최소공배수만큼의 조각이 필요하다는 것이다.
- 6조각은 피자 1판이므로, 우리는 n과 6의 최소공배수를 구하고, 여기서 6만큼을 나누어주면 된다.

---
