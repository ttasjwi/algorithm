# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042686
- 제목 : 더 맵게
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42686" target="_blank">링크</a>

---

# 필요 지식
- 힙

---

# 풀이
```python
import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        first = heapq.heappop(scoville)
        if first >= K:
            return answer
        if not scoville:
            return -1
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first + second * 2)
        answer += 1
```
- 힙을 사용한 이유
  - 가장 맵지 않은(최소), 두번째로 맵지 않은(그 다음 최소)
  - 위에서의 결과물을 다시 섞는다는 점은 삽입을 빈번이 한다는 점
  - 또 다시 가장 맵지 않은(최소), 두번째로 맵지 않은(그 다음 최소)
  - 반복적 삽입, 최솟값 추출이 계속 일어나므로 힙을 쓰는게 좋다는 생각이 들었다.

---

