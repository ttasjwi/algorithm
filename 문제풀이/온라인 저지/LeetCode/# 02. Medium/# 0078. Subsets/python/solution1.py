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
