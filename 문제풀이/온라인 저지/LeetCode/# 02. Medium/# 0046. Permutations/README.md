# 문제
- 플랫폼 : LeetCode
- 번호 : 0046
- 제목 : Permutations
- 난이도 : Medium
- 서로 다른 정수를 입력받아 가능한 모든 순열을 return
- 문제 : <a href="https://leetcode.com/problems/permutations" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)
- itertools.permutations

---

# 풀이
## 풀이1: DFS
```python
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs(k, permutation):
            if k == len(nums):
                answer.append(permutation[:])
                return
            for i in range(len(nums)):
                if not check[i]:
                    check[i] = True
                    permutation[k] = nums[i]
                    dfs(k + 1, permutation)
                    check[i] = False

        check = [False] * len(nums)
        answer = []
        dfs(0, [0] * len(nums))
        return answer
```
- 체크배열 : 중복을 허용하지 않기 위함
- answer에 append할 때 배열을 리스트 슬라이싱을 통해 복사하여 삽입한다.(그냥 삽입하면 참조가 복사된다.)

## 풀이2 : itertools.permutations
```python
from itertools import permutations
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        return permutations(nums)
```
- 단순히 itertools.permutations 객체를 반환해도 정답이 인정된다.
- 참고로 이 객체는 객체는 각각의 순열을 튜플로 반환한다. 별도로 list로 매핑하는게 원칙이긴 하나 그냥 이렇게 반환해도 된다.

---
