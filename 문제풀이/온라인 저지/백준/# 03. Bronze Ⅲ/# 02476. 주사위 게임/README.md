# 문제
- 플랫폼 : 백준
- 번호 : 02476
- 제목 : 주사위 게임
- 난이도 : Bronze 3
- 가장 많은 상금을 받은 사람의 상금을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2476" target="_blank">링크</a>

---

# 필요 지식
- 정렬
- 수학, 구현

---

# 풀이
```python
import sys

src = sys.stdin.buffer
n = int(src.readline())


def get_score(a, b, c):
    if a == c:
        return 10000 + a * 1000
    elif a == b or b == c:
        return 1000 + b * 100
    else:
        return c * 100


print(max([get_score(*sorted(map(int, line.split()))) for line in src.read().splitlines()]))
```
- 나온 눈들을 정렬해서 인자로 제공하면, 정렬 되어있기 떄문에 서로 같은지 다른지 두개가 다른지 판단하기 편리하다.

---
