# 문제
- 플랫폼 : 백준
- 번호 : 11279
- 제목 : 최대 힙
- 난이도 : Silver 2
- 최대 힙을 이용하여 문제에서의 연산을 지원하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11279" target="_blank">링크</a>

---

# 필요 지식
- 힙

---

# 풀이
```python
import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write

src.readline()
q = []
[
    heapq.heappush(q, -k) if k else print(str(-heapq.heappop(q)) + '\n' if q else '0\n')
    for k in map(int, src.read().splitlines())
]
```
- heapq에 값을 삽입할 때 음의 부호로 삽입한다.
- heqpq에서의 최소값에 대해 부호를 뒤집은 값이 최댓값이다.
- 주어진 조건에 따라 출력해 나가면 된다.

---
