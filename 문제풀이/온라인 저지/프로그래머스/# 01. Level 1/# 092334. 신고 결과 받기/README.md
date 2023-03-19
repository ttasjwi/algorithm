# 문제
- 플랫폼 : 프로그래머스
- 번호 : 092334
- 제목 : 신고 결과 받기
- 난이도 : Level 1
- 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92334 target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
from typing import List


def solution(id_list:List[str], reports:List[str], k:int):
    # 각 유저가 신고 받은 횟수
    counter = {id: 0 for id in id_list}

    # 각 유저가 신고한 내역 초기화
    graph = {id: set() for id in id_list}
    for report in reports:
        a, b = report.split()
        if b not in graph[a]:
            graph[a].add(b)
            counter[b] += 1

    # 각 유저의 신고 내역을 다시 읽어가면서, 처리 결과 메일 갯수 정산
    answer = []
    for a in id_list:
        cnt = 0
        for b in graph[a]:
            if counter[b] >= k:
                cnt += 1
        answer.append(cnt)
    return answer
```
- counter: 각 유저가 신고받은 카운트
- graph : 각 유저의 신고 내역들 (중복을 방지하기 위해, set 자료형을 사용했다.)
- 우선 reports를 읽어가면서, 각 유저의 신고내역을 초기화하고, 카운팅한다.
- 신고 내역을 읽고, 카운팅이 완료되면 다시 각 유저의 신고 내역을 순서대로 읽어가면서 결과를 계산한다.

---
