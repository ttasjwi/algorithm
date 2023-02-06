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
