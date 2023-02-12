# 문제
- 플랫폼 : 백준
- 번호 : 07568
- 제목 : 덩치
- 난이도 : Silver 5
- 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7568" target="_blank">링크</a>

---

# 필요 알고리즘
- 브루트 포스

---

# 풀이
```python
import sys

src = sys.stdin.buffer
print = sys.stdout.write

n = int(src.readline())
people = [tuple(map(int, line.split())) for line in src.read().splitlines()]
ranks = [1] * n

for i, (x, y) in enumerate(people):
    for j, (ox, oy) in enumerate(people):
        if i == j:
            continue
        if x > ox and y > oy:
            ranks[j] += 1
print(' '.join(map(str, ranks)))

```
- 등수 배열을 하나 만들고, 다른 사람들과 순위를 순서대로 비교해가며 자기 자신이 크면 다른 사람의 등수를 +1 한다.

---
