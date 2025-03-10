# 문제
- 플랫폼 : 프로그래머스
- 번호 : 118667
- 제목 : 두 큐 합 같게 만들기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/118667" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
```python
from collections import deque


def solution(queue1, queue2):
    sum1 = sum(queue1)
    sum2 = sum(queue2)

    size = len(queue1)

    queue1 = deque(queue1)
    queue2 = deque(queue2)

    for answer in range(size * 4):
        if sum1 > sum2:
            left = queue1.popleft()
            queue2.append(left)
            sum1 -= left
            sum2 += left
        elif sum1 < sum2:
            left = queue2.popleft()
            queue1.append(left)
            sum2 -= left
            sum1 += left
        else:
            return answer
    return -1
```
- 합이 큰 큐에서 작은 큐로 옮기는 것을 반복한다.
- 그런데 넉넉히 양쪽 길이 합의 2배에 해당하는 4 * size 만큼까지 반복
  - 그럼에도 합이 같아지지 않으면 불가능한 것이므로 종료

---
