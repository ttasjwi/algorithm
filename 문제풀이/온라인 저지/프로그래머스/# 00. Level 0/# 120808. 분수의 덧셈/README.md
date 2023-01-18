# Programmers 120808 : 분수의 덧셈
- 난이도 : Level 0
- 두 분수의 합을 구하고, 그 결과를 기약분수로 나타내기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120808)

---

## 풀이
```java
public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bottom = denom1 * denom2;
        int top = numer1 * denom2 + numer2 * denom1;

        int gcd = gcd(bottom, top);

        return new int[]{top/gcd, bottom/gcd};
    }

    private int gcd(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int r = max%min;

        return (r == 0)
                ? min
                : gcd(min, r);
    }
}
```
- 분모를 두 수의 곱으로 하고, 분모를 구한다.
- 이 결과의 분자, 분모의 최대 공약수로 약분한다.
  - 최대공약수는 GCD 알고리즘을 사용한다.

---
