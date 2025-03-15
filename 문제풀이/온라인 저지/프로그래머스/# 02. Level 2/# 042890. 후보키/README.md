# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042890
- 제목 : 후보키
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42890" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
from itertools import combinations


def solution(relation):
    row_count = len(relation)
    col_count = len(relation[0])

    # combs : 가능한 모든 인덱스 조합
    combs = []

    # 칼럼 1개, 2개, ...
    for i in range(1, col_count + 1):
        # 칼럼 i 개의 조합 -> 각각 combs 에 append
        for comb in combinations(range(col_count), i):
            combs.append(comb)

    # 가능한 인덱스 조합 목록
    results = []

    def append_if_not_exist_subset(results, comb, tuples):
        if len(tuples) != row_count:
            return

        for result in results:
            if set(result).issubset(set(comb)):
                return
        results.append(comb)
        return

    for comb in combs:
        tuples = set(tuple([rel[idx] for idx in comb]) for rel in relation)
        append_if_not_exist_subset(results, comb, tuples)

    return len(results)
```
