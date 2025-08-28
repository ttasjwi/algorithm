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
is_prime = [True] * (n + 1)
is_prime[0], is_prime[1] = False, False # 소수가 아니면 False

for i in range(2, int(sqrt(n)) + 1):
    if is_prime[i]:
        for j in range(i * 2, n + 1, i):
            is_prime[j] = False
answer = is_prime.count(True)
print(answer)
```
- 에라토스테네스의 체를 사용하여 합성수를 필터링하고, 소수의 갯수를 센다.

---
