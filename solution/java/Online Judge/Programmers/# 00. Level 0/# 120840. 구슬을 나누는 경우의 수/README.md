# Programmers 120840 : 구슬을 나누는 경우의 수
- 난이도 : Level 0
- 서로 다른 balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120840)

---

## 풀이1
```java
public class Solution1 {

    private int[][] combinations;

    public int solution(int balls, int share) {
        combinations = new int[balls+1][balls+1];
        return combination(balls, share);
    }

    private int combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == 0 || r == n) {
            return combinations[n][0] = combinations[n][n] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][1] = combinations[n][n-1] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }

}
```
- comb(n,r) = comb(n-1, r-1) + comb(n-1, r)

## 풀이2
```java
public class Solution2 {

    private static long[][] combinations;

    public long solution(int balls, int share) {
        combinations = new long[balls+1][balls+1];
        return combination(balls, share);
    }

    private long combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == 0 || r == n) {
            return combinations[n][0] = combinations[n][n] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][1] = combinations[n][n-1] = n;
        }
        long result = combination(n-1, r-1);
        result *= n;
        result /= r;
        return combinations[n][r] = combinations[n][n-r] = result;
    }

}
```
- comb(n,r) = comb(n-1, r-1) * n / r

## 풀이3 : 팩토리얼 값 이용
```java
import java.math.BigInteger;

public class Solution3 {

    private BigInteger[] factorials;

    public int solution(int balls, int share) {
        factorials = new BigInteger[balls+1];
        return combination(balls, share);
    }

    private int combination(int n, int r) {
        return factorial(n)
                .divide(factorial(n-r))
                .divide(factorial(r))
                .intValue();
    }

    private BigInteger factorial(int n) {
        if (factorials[n] != null) {
            return factorials[n];
        }
        if (n == 0 || n == 1) {
            return factorials[n] = BigInteger.ONE;
        }
        return factorials[n] = BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
```
- 조합수를 구하는 기본 공식 `comb(n,r) == n! / (n-r)! * r!` 을 사용하였다.
- 이 경우 팩토리얼 값의 long조차도 벗어나므로 BigInteger를 사용해야한다.
- 세 개의 팩토리얼 값을 계산해야하는데, 팩토리얼 값을 다시 계산하는 것보다 캐싱한 값을 쓰는게 더 시간적으로 이익이므로 캐싱을 했다.

---
