# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042587
- 제목 : 프로세스
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42587" target="_blank">링크</a>

---

# 필요 지식
- 우선순위 큐
- 큐

---

# 풀이
```python
from collections import deque
import heapq


def solution(priorities, location):
    queue = deque()
    heap = []
    for i, p in enumerate(priorities):
        queue.append((i, p))
        heapq.heappush(heap, -p)
    count = 0

    while queue:
        queue_item = queue.popleft()
        if queue_item[1] == -heap[0]:
            heapq.heappop(heap)
            count += 1
            if queue_item[0] == location:
                return count
        else:
            queue.append(queue_item)
```
- priorities 배열의 요소를 순회하며 다음 작업을 한다.
  - 현재 인덱스와 우선순위를 묶은 튜플을 큐에 삽입
  - 우선순위 음수값을 힙에 삽입(우선순위가 높을 수록 우선도가 높음)
- 큐가 빌 때까지 다음을 반복한다.
  - 힙의 최상단 우선순위와 현재 큐 맨앞 요소의 우선순위가 같으면 count 를 증가시키기. 이 때 만약 인덱스가 location 이면 바로 count 반환.
  - 우선순위가 다르면 queue 에 다시 삽입

---
