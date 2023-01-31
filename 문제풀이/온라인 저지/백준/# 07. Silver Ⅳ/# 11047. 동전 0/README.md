# 문제
- 플랫폼 : 백준
- 번호 : 11047
- 제목 : 동전 0
- 난이도 : Silver 4
- 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 할 때 필요한 동전 개수의 최솟값
- 문제 : <a href="https://www.acmicpc.net/problem/11047" target="_blank">링크</a>

---

# 필요 알고리즘
- 그리디 알고리즘

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n, k = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

count = 0
for i in range(n - 1, -1, -1):
    current, k = divmod(k, numbers[i])
    count += current
    if k == 0:
        break
print(str(count))
```
- 동전의 큰 단위가 각각 이전 작은 단위의 배수이므로, 가능한 큰 단위의 동전으로 교환할 수록 동전을 적게 사용할 수 있다.
- 큰 동전 단위부터 순서대로 환전해 나간다.

---
