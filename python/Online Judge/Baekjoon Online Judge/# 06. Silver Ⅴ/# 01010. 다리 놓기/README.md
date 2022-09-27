# BOJ 01010 : 다리 놓기

- 난이도 : Silver 5
- 다리를 놓되 서로 교차하지 않게 놓는 방법의 수
- 문제 : [링크](https://www.acmicpc.net/problem/1010)

---

## 기본 풀이 방법

- 오른쪽 도시에서 n개를 택하면, 다리를 놓는 방법은 위부터 순서대로 놓아진다.
- m개 중 n개를 택하는 조합수를 구하면 된다.

## 풀이1 : math 모듈 사용

```python
import math
import sys

_ = input()

for line in sys.stdin:
    n, m = map(int, line.split())
    comb = math.comb(m, n)
    print(comb)
```

---

## 풀이2 : 직접 조합수 구하기
```python
import sys

dp = [[None for _ in range(30)] for _ in range(30)]


def main():
    _ = input()
    for line in sys.stdin:
        n, m = map(int, line.split())
        print(comb(m, n))


def comb(m: int, n: int) -> int:
    if not dp[m][n] is None:
        return dp[m][n]
    if n == 0 or n == m:
        dp[m][n] = 1
        dp[m][m - n] = 1
        return dp[m][n]
    if n == 1 or n == m - 1:
        dp[m][n] = m
        dp[m][m - n] = m
        return dp[m][n]
    dp[m][n] = comb(m - 1, n - 1) + comb(m - 1, n)
    dp[m][m - n] = dp[m][n]
    return dp[m][n]


main()

```

---
