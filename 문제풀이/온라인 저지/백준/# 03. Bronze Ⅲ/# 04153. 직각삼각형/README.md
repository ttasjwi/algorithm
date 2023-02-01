# 문제
- 플랫폼 : 백준
- 번호 : 04153
- 제목 : 직각삼각형
- 난이도 : Bronze 3
- 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분
- 문제 : <a href="https://www.acmicpc.net/problem/4153" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학

---

# 풀이
```python
import sys


def solution(line):
    numbers = sorted(map(int, line.split()))
    return 'right' if numbers[0] ** 2 + numbers[1] ** 2 == numbers[2] ** 2 else 'wrong'


answer = '\n'.join(solution(line.rstrip()) for line in sys.stdin.readlines()[:-1])
print(answer, end='')
```
- 정렬 후 피타고라스의 정리로 판단

---
