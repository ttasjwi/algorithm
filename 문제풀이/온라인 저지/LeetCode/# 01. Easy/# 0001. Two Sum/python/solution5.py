from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums = sorted([(idx, num) for idx, num in enumerate(nums)], key=lambda x: x[1])

        lt, rt = 0, len(nums) - 1
        while not lt == rt:
            if nums[lt][1] + nums[rt][1] < target:
                lt += 1
            elif nums[lt][1] + nums[rt][1] > target:
                rt -= 1
            else:
                return [nums[lt][0], nums[rt][0]]
