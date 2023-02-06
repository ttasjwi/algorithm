# 문제
- 플랫폼 : 백준
- 번호 : 01010
- 제목 : 다리 놓기
- 난이도 : Silver 5
- 다리를 놓되 서로 교차하지 않게 놓는 방법의 수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1010" target="_blank">링크</a>

---

# 필요 지식
- 수학(조합론)
- 다이나믹 프로그래밍

---

# 풀이
- 오른쪽 도시에서 n개를 택하면, 다리를 놓는 방법은 위부터 순서대로 놓아진다.
- m개 중 n개를 택하는 조합수를 구하면 된다.

## 풀이1 : 다이나믹 프로그래밍
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    answer = []
    dp = [[0] * (k + 1) for k in range(30)]

    for m in range(30):
        for n in range(0, m // 2 + 1):
            if n == 0:
                dp[m][0] = dp[m][m] = 1
            elif n == 1:
                dp[m][1] = dp[m][m - 1] = m
            else:
                dp[m][n] = dp[m][m - n] = dp[m - 1][n - 1] + dp[m - 1][n]

    for _ in range(int(input())):
        n, m = map(int, input().split())
        answer.append(str(dp[m][n]))
    print('\n'.join(answer))


if __name__ == '__main__':
    main()
```
- 미리 1C0부터 30C30까지 계산해둔다.
- 이후 바로 접근해서 출력


## 풀이2 : math 모듈 사용
```python
import sys
from math import comb

input = sys.stdin.readline
print = sys.stdout.write

answer = []
for _ in range(int(input())):
    n, m = map(int, input().split())
    answer.append(str(comb(m, n)))
print('\n'.join(answer))
```

---
