# BOJ 01978 : 소수 찾기

- 난이도 : Silver 5
- 주어진 수 N개 중에서 소수의 수
- 문제 : [링크](https://www.acmicpc.net/problem/1978)

---

## 풀이
```python
import sys

input = lambda: sys.stdin.readline().rstrip()
n = int(input())
numbers = list(map(int, input().split()))
max_number = max(numbers)

is_composite_number = [False for i in range(max_number+1)]
is_composite_number[1] = True

for i in range(2, max_number + 1):
    if not is_composite_number[i]:
        for j in range(2 * i, max_number + 1, i):
            is_composite_number[j] = True

answer = 0
for number in numbers:
    if not is_composite_number[number]:
        answer += 1


print(answer, end='')

```
- 에라토스테네스의 체를 활용했다.

---
