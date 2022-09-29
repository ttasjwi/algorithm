# LeetCode 00001 : Two Sum
- 난이도 : Easy
- 지정된 합을 만드는 숫자 조합을 확인후 그 인덱스들을 배열로 반환하기
- 문제 : [링크](https://leetcode.com/problems/two-sum/)

---

# 풀이

## 풀이1 : 브루트포스
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(0, len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target: # 합했을 때 같으면
                    return [i, j]

```
- 시간 복잡도 : `O(n^2)`
- 정확히는 `1/2 n^2` 정도 된다.


## 풀이2 : in 이용
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, a in enumerate(nums):
            b = target - a # 목표값에서 현재 숫자를 뺀 값, 즉 짝
            
            if b in nums[i+1:]: # 짝이 다른 곳에 있다면
                return [i, nums[i+1:].index(b) + (i+1)]

```
- 시간 복잡도 : `O(n^2)`
- 파이썬 내부적으로 in을 사용 시 가볍고 빠르게 진행되기에 더 빠르다

## 풀이3 : 첫번째 수를 뺀 결과(짝)를 해시테이블에서 조회
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for i, num in enumerate(nums):
            nums_map[num] = i  # 해시 테이블에 순서대로 저장. 중복된 num이 들어오면 나중에 들어온 값으로 덮어 씌워진다. 

        for i, a in enumerate(nums):
            b = target - a  # 짝

            if b in nums_map and i != nums_map[b]:  # 짝이 리스트에 존재하면 그 인덱스를 반환.
                return [i, nums_map[b]]

```
- 시간 복잡도 : `O(n)`
- 해시테이블에 할당하므로, 조회 시 `O(1)` 소요

## 풀이4 : 조회 구조 개선 - 1개의 for문
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for i, a in enumerate(nums):
            b = target - a # 짝
            if b in nums_map: # 이미 등록해둔 짝이 map에 있으면
                return [nums_map[b], i] # 짝의 인덱스, 현재 인덱스 반환
            nums_map[a] = i # 없으면 현재값을 맵에 put
```
- for문 하나로 해결할 수 있다.
- 모두 저장할 필요 없이, 답을 찾으면 바로 탈출할 수 있다.
- python에서는 이 풀이가 제일 빠르다.

## 풀이5 : 투 포인터
```python
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
```
- 시간복잡도 : O(n)
- 정렬, 튜플 변환 등의 시간이 좀 많이 걸린다.
- 정렬하면 인덱스가 뒤죽박죽 섞이므로 튜플로 감싸서 저장해야한다.

---
