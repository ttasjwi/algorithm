# 문제
- 플랫폼 : 백준
- 번호 : 02721
- 제목 : 삼각수의 합
- 난이도 : Bronze 3
- 각 테스트 케이스에 대해 W(n)을 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2791" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write
t = int(input())

dp_f = [0] * 302
dp_g = [0] * 302


def f(k):
    if dp_f[k] > 0:
        return dp_f[k]
    dp_f[k] = k * (k + 1) // 2
    return dp_f[k]


def g(k):
    if dp_g[k] > 0:
        return dp_g[k]
    dp_g[k] = k * f(k + 1)
    return dp_g[k]


for _ in range(t):
    print(str(sum([g(x) for x in range(1, int(input()) + 1)])))
    print('\n')
```
- 배열에 한번 계산한 값 저장

---
