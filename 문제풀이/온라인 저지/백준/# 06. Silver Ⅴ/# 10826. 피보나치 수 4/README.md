# 문제
- 플랫폼 : 백준
- 번호 : 10826
- 제목 : 피보나치 수 4
- 난이도 : Silver 5
- 첫째 줄에 n번째 피보나치 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10826" target="_blank">링크</a>

---

# 필요 지식
- DP

---

# 풀이
```python
n = int(input())

if n == 0:
    print(0)
else:
    dp = [0] * (n + 1)
    dp[1] = 1

    for i in range(2, n + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    print(dp[n])
```
- n이 0인 경우, 그리고 그것이 아닌 경우를 분류해야 틀리지 않음.
- 바텀업 방식의 DP를 사용했다.

---
