# 문제
- 플랫폼 : LeetCode
- 번호 : 0078
- 제목 : Subsets
- 난이도 : Medium
- 모든 부분 집합을 리턴하라.
- 문제 : <a href="https://leetcode.com/problems/subsets" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)

---

# 풀이

## 풀이1
```python
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(idx, numbers):
            if idx == len(nums):
                answer.append(numbers)
                return
            dfs(idx + 1, numbers + [nums[idx]])
            dfs(idx + 1, numbers[:])

        answer = []
        dfs(0, [])
        print(answer)
        return answer
```
- 부분집합 결정 문제는 어떤 요소가 포함되냐, 포함되지 않느냐 두 가지 선택에서 결정된다.
- idx번 인덱스의 요소를 포함시킨 경우, 포함시키지 않은 경우 양쪽에 대해서 순서대로 dfs를 해주면 된다.

## 풀이2
```python
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(idx, numbers):
            answer.append(numbers)
            for i in range(idx, len(nums)):
                dfs(i+1, numbers + [nums[i]])

        answer = []
        dfs(0, [])
        print(answer)
        return answer
```
- 파이썬 알고리즘 인터뷰 책에서는 이 풀이를 사용하였다.
- 우선 기존 요소에 아무 것도 추가하지 않고, 바로 append하는 경우
- 그리고, 기존 요소에 i번 요소부터 추가하는 경우다.
- 이 방식대로 dfs 처리를 하면 모든 경우의 부분집합을 구할 수 있다.

---
