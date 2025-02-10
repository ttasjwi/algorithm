# 문제
- 플랫폼 : 프로그래머스
- 번호 : 138476
- 제목 : 귤 고르기
- 난이도 : Level 2
- 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138476" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```python
from collections import Counter

def solution(k, tangerine):
    counter = Counter(tangerine)
    answer = 0
    for value in sorted(counter.values(), reverse=True):
        answer += 1
        k -= value
        if k <= 0:
            return answer
```
- 귤의 갯수들을 카운팅하고, value 기준으로 내림차순 정렬한다.
- 귤의 갯수가 많은 것부터 우선적으로 박스에 담는다.
  - 귤의 갯수가 많은 것을 우선적으로 담을 수록 귤의 크기 종류가 적어진다.

---
