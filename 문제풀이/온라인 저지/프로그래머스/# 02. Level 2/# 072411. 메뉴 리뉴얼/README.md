# 문제
- 플랫폼 : 프로그래머스
- 번호 : 072411
- 제목 : 메뉴 리뉴얼
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72411" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
from itertools import combinations
from collections import Counter

def solution(orders, course):
    result = []
    for r in course:
        counter = Counter([''.join(sorted(tuple)) for order in orders for tuple in combinations(order, r)]).most_common()
        if not counter or counter[0][1] == 1:
            continue
        for k, v in counter:
            if v != counter[0][1]:
                break
            result.append(k)
    return sorted(result)
```
