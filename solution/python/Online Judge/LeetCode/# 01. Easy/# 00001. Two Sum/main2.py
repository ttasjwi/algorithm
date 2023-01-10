from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, a in enumerate(nums):
            b = target - a # 목표값에서 현재 숫자를 뺀 값, 즉 짝

            if b in nums[i+1:]: # 짝이 다른 곳에 있다면
                return [i, nums[i+1:].index(b) + (i+1)]

