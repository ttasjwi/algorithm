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
