# 문제
- 플랫폼 : 백준
- 번호 : 02579
- 제목 : 계단 오르기
- 난이도 : Silver 3
- 문제 : <a href="https://www.acmicpc.net/problem/2579" target="_blank">링크</a>

---

# 필요 지식
- DP

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
nums = [0] + [int(input()) for _ in range(n)]
dp = [0] * (n+1)

for i in range(1, n+1):
    if i == 1:
        dp[i] = nums[1]
    elif i == 2:
        dp[i] = nums[1] + nums[2]
    else:
        dp[i] = max(dp[i-3] + nums[i-1], dp[i-2]) + nums[i]
print(str(dp[n]))
```

