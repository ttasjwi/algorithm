# BOJ 02805 : 나무 자르기

- 난이도 : Silver 2
- 나무를 집에 가져가기 위해, 절단기로 설정할 수 있는 높이의 최댓값  
- 문제 : [링크](https://www.acmicpc.net/problem/2805)

---

## 풀이
```python
import sys
from collections import Counter

n, m, *heights = map(int, sys.stdin.buffer.read().split())
heights = Counter(heights).items()
lt, rt = 0, max(heights)[0] - 1
answer = 0

while lt <= rt:
    mid = (lt + rt) // 2
    total = 0
    for height, count in heights:
        if height > mid:
            total += (height - mid) * count
    if total >= m:
        answer = mid
        lt = mid + 1
    else:
        rt = mid - 1
print(answer, end='')

```
- 연속된 정수 범위 내에서 특정 조건을 만족하는 최적의 값을 찾아내는 것이므로, 매개변수 탐색을 사용하면 된다

---
