from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(idx, numbers):
            answer.append(numbers)
            for i in range(idx, len(nums)):
                dfs(i + 1, numbers + [nums[i]])

        answer = []
        dfs(0, [])
        print(answer)
        return answer
