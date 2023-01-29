from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx, num in enumerate(nums):
            complement = target - num
            if complement in nums[idx + 1:]:
                return [idx, nums[idx + 1:].index(complement) + (idx + 1)]
