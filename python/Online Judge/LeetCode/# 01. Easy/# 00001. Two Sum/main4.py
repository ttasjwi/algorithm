from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for i, a in enumerate(nums):
            b = target - a # 짝
            if b in nums_map: # 이미 등록해둔 짝이 map에 있으면
                return [nums_map[b], i] # 짝의 인덱스, 현재 인덱스 반환
            nums_map[a] = i # 없으면 현재값을 맵에 put


