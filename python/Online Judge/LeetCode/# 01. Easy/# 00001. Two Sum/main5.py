from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums = map([(i, nums[i]) for i in range(len(nums))])
        nums.sort(key=lambda x: (x[1], x[0])) # 정렬을 하면 인덱스가 깨져버리므로 앞에서 튜플의 형태로 인덱스를 저장해야한다.
        lt, rt = 0, len(nums) - 1
        while lt != rt:
            if nums[lt][1] + nums[rt][1] < target:
                lt += 1
            elif nums[lt][1] + nums[rt][1] > target:
                rt -= 1
            else:
                return [nums[lt][0], nums[rt][0]]
