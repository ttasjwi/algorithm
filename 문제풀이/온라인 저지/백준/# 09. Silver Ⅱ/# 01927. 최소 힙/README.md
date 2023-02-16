# 문제
- 플랫폼 : 백준
- 번호 : 01927
- 제목 : 최소 힙
- 난이도 : Silver 2
- 최소 힙을 이용하여 주어진 연산을 수행하는 프로그램 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1927" target="_blank">링크</a>

---

# 필요 알고리즘
- 최소 힙
  - 루트가 항상 작은 값
  - 자식은 자신보다 크기만 하면 됨
  - 완전 이진트리(왼쪽 자식부터 채워야 함)
  - 삽입의 시간 복잡도 : O(logN)
  - 추출의 시간 복잡도 : O(logN)
  - 최솟값 확인 : O(1)

---

# 풀이
```python
import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write

src.readline()
nums = list(map(int, src.read().splitlines()))

q = []
for num in nums:
    if num:
        heapq.heappush(q, num)
    else:
        if not q:
            print('0')
            print('\n')
        else:
            item = heapq.heappop(q)
            print(str(item))
            print('\n')
```
- heapq에 데이터를 삽입하고 지시대로 따르면 된다.

---
