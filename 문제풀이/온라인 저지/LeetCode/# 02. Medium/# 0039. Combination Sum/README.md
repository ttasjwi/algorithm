# 문제
- 플랫폼 : LeetCode
- 번호 : 0039
- 제목 : Combination Sum
- 난이도 : Medium
- 숫자 집합 candidates를 조합하여 합이 target이 되는 원소를 나열하라. 각 원소는 중복으로 나열 가능하다.
- 문제 : <a href="https://leetcode.com/problems/combination-sum" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)
- 백 트래킹

---

# 풀이
```python
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(total, start, numbers):
            if total > target:
                return
            if total == target:
                answer.append(numbers)
                return
            for i in range(start, len(candidates)):
                dfs(total + candidates[i], i, numbers + [candidates[i]])

        answer = []
        dfs(0, 0, [])
        return answer
```
- 합이 target을 넘는 경우 거기서 재귀를 그만둔다.
- 합이 target과 같을 경우 answer에 append한다.
- start를 지정하여, 이전의 원소를 다시 탐색하여 중복되는 경우를 없앴다. 재귀 함수를 호출할 때 같은 인덱스부터 시작하게 하면
중복을 허용하면서도 이전 인덱스의 요소를 포함하지 않게 할 수 있다.

---
