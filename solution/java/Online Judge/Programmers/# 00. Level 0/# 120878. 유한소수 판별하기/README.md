# 문제
- 번호 : 120878
- 제목 : 유한소수 판별하기
- 난이도 : Level 0
- a/b가 유한소수이면 1을, 무한소수라면 2를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120878)

---

# 필요 알고리즘
- GCD

---

# 풀이
```java
public class Solution {

    public int solution(int a, int b) {
        if (a == b) return 1;
        int max, min;

        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        b /= gcd(max, min);

        while (b % 2 == 0) {
            b /= 2;
        }

        while (b % 5 == 0) {
            b /= 5;
        }

        return (b == 1)
                ? 1
                : 2;
    }

    private int gcd(int max, int min) {
        int r = max % min;
        return (r == 0)
                ? min
                : gcd(min, r);
    }

}
```
- a, b의 GCD(최대공약수)를 구한다.
- b를 GCD로 나눈다.
- b를 2로 나누어 떨어지지 않을 때까지 계속 나눈다.
- b를 5로 나누어 떨어지지 않을 때까지 계속 나눈다.
- 마지막의 b가 1이면, 유한 소수이고, 1이 아니면 무한 소수다.

---
