# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042586
- 제목 : 기능개발
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42586" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
```python
from collections import deque

def solution(progresses, speeds):
    answer = []
    queue = deque()

    # 각 작업의 비용을 구하고, queue 에 순서대로 담기
    for progress, speed in zip(progresses, speeds):
        cost, remainder = divmod(100 - progress, speed)
        if remainder:
            cost += 1
        queue.append(cost)

    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 꺼낸 값을 경과 일로 삼음
        elapsed_day = queue.popleft()
        
        # 경과 일까지 한 작업의 수
        count = 1

        # 경과일보다 비용이 작거나 같은 작업들을 큐에서 모두 꺼내서 count 증가
        while queue and queue[0] <= elapsed_day:
            queue.popleft()
            count += 1
        
        # 경과일(배포일)까지 한 작업의 수를 answer에 담음
        answer.append(count)
    return answer
```
- 우선, 각 작업들의 소요비용을 산정하여, 큐에 순서대로 삽입한다.
  - 큐는 선입 선출구조(FIFO) 이므로 꺼낼 때마다 먼저 삽입된 것이 뽑아진다.
- 큐가 빌 때까지 다음을 반복한다.
  - 큐에서 우선 비용을 하나 꺼낸다. 이 비용만큼을 '경과 일(elapsed_day)' 로 삼는다.
    - 이 작업이 끝날 때까지는 뒤에 이어지는 비용이 더 작거나 같은 작업들은 배포되지 못 한다.
  - 경과일까지 한 작업의 수를 count 로 삼는다.
  - 큐에서 '경과일'과 같거나 작은 비용들을 순서대로 꺼내면서, count 를 증가시킨다.
  - count 를 answer 에 append 한다.
- answer 를 반환한다.

---
