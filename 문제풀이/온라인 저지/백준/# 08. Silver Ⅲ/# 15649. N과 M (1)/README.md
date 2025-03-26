# 문제
- 플랫폼 : 백준
- 번호 : 15649
- 제목 : N과 M (1)
- 난이도 : Silver 3
- 문제 : <a href="https://www.acmicpc.net/problem/15649" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이

## 풀이1: 백트래킹
```python
import sys

print = sys.stdout.write
n, m = map(int, input().split())
nums = list(map(str, range(1, n + 1)))
check = [False] * n
result = []

arr = []

def back_tracking(depth):
    if depth == m:
        result.append(' '.join(arr))
        return
    for idx in range(n):
        if not check[idx]:
            check[idx] = True
            arr.append(nums[idx])
            back_tracking(depth + 1)
            arr.pop()
            check[idx] = False


back_tracking(0)
print('\n'.join(result))
```

## 풀이2: python 의 permutations 활용
```python
import sys
from itertools import permutations

print = sys.stdout.write
n, m = map(int, input().split())

print('\n'.join(list(map(' '.join, permutations(map(str, range(1, n+1)), m)))))
```

---
