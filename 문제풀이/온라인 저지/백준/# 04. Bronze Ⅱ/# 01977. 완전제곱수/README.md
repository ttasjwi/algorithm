# 문제
- 플랫폼 : 백준
- 번호 : 01977
- 제목 : 완전제곱수
- 난이도 : Bronze 2
- M이상 N이하의 자연수 중 완전제곱수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1977" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학

---

# 풀이

## 풀이1
```python
from math import sqrt

nums = [k for k in range(int(input()), int(input()) + 1) if sqrt(k) == int(sqrt(k))]
if not nums:
    print('-1')
else:
    print(sum(nums))
    print(nums[0])
```
- 조건대로 m부터 n까지 정수들 각각을 연산하여, 완전제곱수 연산 여부를 판단한다.
- 만약 1부터 10000까지 갯수를 세라고 한다면 10000번 연산해야한다.


## 풀이2
```python
from math import sqrt, ceil, floor

nums = [k ** 2 for k in range(ceil(sqrt(int(input()))), floor(sqrt(int(input()))) + 1)]

if not nums:
    print('-1')
else:
    print(sum(nums))
    print(nums[0])
```
- 우리가 찾는건 결국 sqrt(m) 이상 sqrt(n) 이하의 정수의 제곱값들이다.
- 만약 1부터 10000까지 갯수를 세라고 한다면 1이상 100이하의 정수의 제곱값들을 모으기만 하면 된다.

---
