# 문제
- 플랫폼 : LeetCode
- 번호 : 0077
- 제목 : Combinations
- 난이도 : Medium
- 전체수 n을 입력받아 k개의 조합을 리턴하라.
- 문제 : <a href="https://leetcode.com/problems/combinations" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)
- itertools.combinations

---

# 풀이
## 풀이1: DFS
```python
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def dfs(m, start, nums):
            if m == k:
                answer.append(nums[:])
                return
            for i in range(start, n + 1):
                nums[m] = i
                dfs(m + 1, i + 1, nums)

        answer = []
        dfs(0, 1, [0] * k)
        return answer
```
- m이 k가 되면 선택된 숫자들을 answer에 append한다.
- 반복 시작을 start로 두고, 다음 재귀 호출 시에는 그 다음 번호부터 시작하도록 하여 중복을 회피할 수 있다.

## 풀이2: itertools.combinations
```python
from itertools import combinations
from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        return combinations(range(1, n + 1), k)
```
- itetools.combinations를 이용하여 편리하게 조합을 사용할 수 있다.

---
