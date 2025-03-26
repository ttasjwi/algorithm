# 문제
- 플랫폼 : 백준
- 번호 : 01920
- 제목 : 수 찾기
- 난이도 : Silver 4
- 문제 : <a href="https://www.acmicpc.net/problem/1920" target="_blank">링크</a>

---

# 필요 지식
- 해시테이블
- 이분탐색

---

# 풀이
### 풀이1 : 해시테이블
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

input()
nums = set(input().split())

input()
print('\n'.join('1' if item in nums else '0' for item in input().split()))
```
- set(해시테이블 자료구조) 에 숫자을 저장
- 이후 등장하는 m 개의 숫자들은 set 에서 조회 후 있으면 '1' 없으면 '0' 출력

### 풀이2: 이분탐색
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

input()
nums = sorted(map(int, input().split()))

def binary_search(num):
    lt = 0
    rt = len(nums) - 1
    while lt <= rt:
        mid = (lt + rt) >> 1
        if nums[mid] == num:
            return '1'
        elif nums[mid] < num:
            lt = mid + 1
        else:
            rt = mid - 1
    return '0'

input()
print('\n'.join(binary_search(num) for num in list(map(int, input().split()))))
```

---
