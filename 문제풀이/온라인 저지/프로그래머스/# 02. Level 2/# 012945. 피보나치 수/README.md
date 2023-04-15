# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012945
- 제목 : 피보나치 수
- 난이도 : Level 2
- n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12945" target="_blank">링크</a>

---

# 필요 지식
- DP

---

# 풀이
```python
def solution(n):
    dp = [0, 1] + [-1] * (n - 1)

    for i in range(2, n + 1):
        dp[i] = (dp[i - 2] % 1234567 + dp[i - 1] % 1234567)
    return dp[n] % 1234567
```
- 바텀업 방식의 DP 사용

---
