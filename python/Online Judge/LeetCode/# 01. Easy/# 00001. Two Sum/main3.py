from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for i, num in enumerate(nums):
            nums_map[num] = i  # 해시 테이블에 순서대로 저장. 중복된 num이 들어오면 나중에 들어온 값으로 덮어 씌워진다.

        for i, a in enumerate(nums):
            b = target - a  # 짝

            if b in nums_map and i != nums_map[b]:  # 짝이 리스트에 존재하면 그 인덱스를 반환.
                return [i, nums_map[b]]

