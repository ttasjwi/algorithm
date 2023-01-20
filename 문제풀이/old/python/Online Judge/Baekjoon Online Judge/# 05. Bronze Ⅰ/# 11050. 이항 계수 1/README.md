# BOJ 11050 : 이항 계수 1
- 난이도 : Bronze 1
- 조합수 구하기
- 문제 : [링크](https://www.acmicpc.net/problem/11050)

---  

## 풀이1 : 파이썬 모듈
```python
import math

n, k = map(int, input().split())
print(math.comb(n,k), end='')
```
- `math.comb(n,k)` 사용

## 풀이2 : 재귀호출 사용
```python
dp = [[None for _ in range(11)] for _ in range(11)]


def main():
    n, k = map(int, input().split())
    answer = comb(n, k)
    print(answer, end='')


def comb(n: int, k: int) -> int:
    if not dp[n][k] is None:
        return dp[n][k]
    if k == 0 or k == n:
        dp[n][k] = 1
        dp[n][n - k] = 1
        return dp[n][k]
    if k == 1 or k == n - 1:
        dp[n][k] = n
        dp[n][n - k] = n
        return dp[n][k]
    dp[n][k] = comb(n - 1, k - 1) + comb(n - 1, k)
    dp[n][n - k] = dp[n][k]
    return dp[n][k]


main()
```

---
