# 문제
- 플랫폼 : 프로그래머스
- 번호 : 142085
- 제목 : 디펜스 게임
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/142085" target="_blank">링크</a>

---

# 필요 지식
- 힙

---

# 풀이
```python
from heapq import heappush, heappop


def solution(n, k, enemy):
    heap = []

    for i, e in enumerate(enemy):
        # 현재 적의 수만큼 차감하고, 최대힙에 삽입
        n -= e
        heappush(heap, -e)

        # 적의 수가 더 많아서 n 이 0보다 작아졌을 경우
        if n < 0:
            if k > 0:
                # 무적권이 있다면, 무적권을 사용하고 heap 에서 최댓값을 찾아 그만큼 n을 복원
                n += - heappop(heap)
                k -= 1
            else:
                # 무적권이 없다면, 라운드 값을 반환
                return i
    return len(enemy)  # 끝까지 살았으면 enemy 배열 길이를 반환
```

---
