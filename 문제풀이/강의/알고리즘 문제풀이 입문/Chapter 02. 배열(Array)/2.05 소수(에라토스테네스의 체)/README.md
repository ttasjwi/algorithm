# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.05
- 제목 : 소수(에라토스테네스의 체)
- 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력

---

# 필요 지식
- 에라토스테네스의 체

---

# 풀이
```python
from math import sqrt

n = int(input())
check = [True, True] + [False] * (n - 1)

for i in range(2, int(sqrt(n)) + 1):
    if not check[i]:
        for j in range(2 * i, n + 1, i):
            check[j] = True
print(check.count(False), end='')
```
- 에라토스테네스의 체를 사용하여 합성수를 필터링하고, 소수의 갯수를 센다.

---
