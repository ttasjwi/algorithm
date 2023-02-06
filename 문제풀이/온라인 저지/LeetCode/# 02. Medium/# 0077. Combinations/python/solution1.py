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
