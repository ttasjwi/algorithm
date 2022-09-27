# BOJ 25304 : 영수증
- 난이도 : Bronze 5
- 구매액과 계산된 총금액이 서로 맞는지 비교 후 출력
- 문제 : [링크](https://www.acmicpc.net/problem/25304)

---  

## 풀이
```python
import sys

x = int(sys.stdin.readline().rstrip())
n = int(sys.stdin.readline().rstrip())

total = 0
for i in range(n):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    total += a * b

print("Yes" if total == x else "No", end='')

```
- 반복을 돌려서 누적 금액을 합산 후 비교하여 결과 출력

---
