
# \[BOJ_10872\] 팩토리얼

- 난이도 : Bronze5
- 재귀를 이용해 팩토리얼 구현
- 문제: <a href="https://www.acmicpc.net/problem/10872" target="_blank"> [링크]</a>

---

## 풀이 방식
```java
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
```
- 종료조건 : n이 0 또는 1일 때
- 이외 : 자기 자신 * factorial(n-1);

---
