# 문제
- 플랫폼 : 백준
- 번호 : 02061
- 제목 : 좋은 암호
- 난이도 : Bronze 3
- K와 L이 주어졌을 때, 좋은 암호인지 판단하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2061" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys


def solution(k, l):
    # K의 가장 작은 인수를 찾기 위해 2부터 시작
    for i in range(2, int(l)):
        if k % i == 0:
            return f"BAD {i}"

    return "GOOD"


k, l = map(int, sys.stdin.readline().split())
answer = solution(k, l)
print(answer)
```
- 2부터 시작해서 가장 작은 인수를 찾는다.
- 가장 작은 인수가 l 미만에서 발견될 경우 나쁜 암호이다.

---
