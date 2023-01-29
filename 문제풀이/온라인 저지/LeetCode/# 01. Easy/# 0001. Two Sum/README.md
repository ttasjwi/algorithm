# 문제
- 플랫폼 : LeetCode
- 번호 : 0001
- 제목 : Two Sum
- 난이도 : Easy
- 덧셈을 하여 target을 만들 수 있는 배열의 두 숫자 인덱스를 반환하기
- 문제 : <a href="https://leetcode.com/problems/two-sum" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스
- 해시
- 투 포인터

---

# 풀이

## 풀이1 : 브루트 포스
```python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
```
- 배열을 2번 반복하면서, 모든 조합을 더해 일일이 확인하는 무차별 대입
- 시간 복잡도 : O(N^2)
- 지나치게 느리다. 8522 ms가 소요됐다.

## 풀이2 : 첫번째 수를 뺀 결과를 in을 이용하여 탐색하기
```python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx, num in enumerate(nums):
            complement = target - num
            if complement in nums[idx + 1:]:
                return [idx, nums[idx + 1:].index(complement) + (idx + 1)]
```
- target에서 현재 값을 뺀 나머지 값이 뒤의 인덱스에서 발견되는 지 in절로 탐색
- 시간복잡도는 여전히 O(N^2)이지만, 파이썬 내부적으로 구현된 in이 빨리 실행됨
- 소요 시간 : 620 ms

## 풀이3 : 첫번째 수를 뺀 결과를 해시를 통해 조회
```python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {num: idx for idx, num in enumerate(nums)}

        for i, num in enumerate(nums):
            if target - num in nums_map and i != nums_map[target - num]:
                return [i, nums_map[target-num]]
```
- 처음에 idx, num을 뒤집어서 딕셔너리에 저장
- 이후 in 절 대신, 딕셔너리를 통해 조회하면 접근 속도를 O(1)로 줄일 수 있다.
- 전체 시간 복잡도는 O(N)이 된다.
- 소요 시간 : 46ms

## 풀이4 : 풀이3에서 조회구조 개선
```python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for idx, num in enumerate(nums):
            if target - num in nums_map:
                return [nums_map[target - num], idx]
            nums_map[num] = idx
```
- 하나의 for문으로 통합
- 모두 저장할 필요 없이, 정답을 찾으면 바로 탈출하고 정답이 아니면 딕셔너리에 삽입
- 하지만, 두번째 값을 찾기 위해 매번 비교해야하기 때문에 앞의 풀이와 비교시 성능상 이점은 크게 없다.

## 풀이5 : 투 포인터
```python
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
```
- 리스트를 정렬한뒤, 투 포인터를 통해 옮겨가면서 target을 찾음.
- 이 방식 역시 시간복잡도 O(N)
- 64 ms 정도 소요

---
