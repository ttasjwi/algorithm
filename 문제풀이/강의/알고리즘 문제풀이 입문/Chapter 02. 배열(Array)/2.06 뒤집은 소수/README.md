# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.06
- 제목 : 뒤집은 소수
- N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력

---

# 필요 지식
- 에라토스테네스의 체

---

## 풀이
```python
from math import sqrt

input()
nums = [int(s[::-1]) for s in input().split()]
mx = max(nums)

check = [True, True] + [False] * (mx - 1)
for i in range(2, int(sqrt(mx)) + 1):
    if not check[i]:
        for j in range(2 * i, mx + 1, i):
            check[j] = True

print(' '.join(str(num) for num in nums if not check[num]), end='')
```
- 입력 문자들을 모두 뒤집고 숫자화한다.
- 이들 중 최댓값을 구한다.
- 최댓값 범위까지 에라토스테네스의 체를 적용하여 소수를 판별한다.
- 소수들만 출력한다.

---
