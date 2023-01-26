# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012977
- 제목 : 소수 만들기
- 난이도 : Level 1
- nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12977" target="_blank">링크</a>

---

# 필요 지식
- 소수 만들기

---

# 풀이
```python
from itertools import combinations
from math import sqrt


def solution(nums):
    check = [False, True] + [False] * 2999

    for i in range(2, int(sqrt(3000)) + 1):
        if not check[i]:
            for j in range(2 * i, len(check), i):
                check[j] = True

    return len([1 for comb in combinations(nums, 3) if not check[sum(comb)]])
```
- 숫자 범위가 1000이하이므로, 최대 3000까지 소수를 찾는다.
- 소수를 찾아 combinations를 통해 조합을 주하고, 조합의 합을 토대로 판별한다.