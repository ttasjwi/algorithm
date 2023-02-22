# 문제
- 플랫폼 : 백준
- 번호 : 09375
- 제목 : 패션왕 신해빈
- 난이도 : Silver 3
- 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9375" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

answers = []
for _ in range(int(input())):
    n = int(input())
    counter = {}
    if n == 0:
        answers.append('0')
        continue
    for _ in range(n):
        _, part = input().split()
        if part in counter:
            counter[part] += 1
        else:
            counter[part] = 1
        product = 1
        for v in counter.values():
            product *= (v + 1)
    answers.append(str(product - 1))
print('\n'.join(answers))
```
- 만약 의상의 종류가 0종류이면 0을 추가한다.
- 각각의 종류별 의상 갯수를 구한다.
- 해당 종류의 의상을 입지 않거나, 그 중 하나를 선택할 수 있으므로 각각의 (의상의 갯수 + 1)을 곱한다.
- 의상을 아무 것도 입지 않는 경우는 제거해야하므로 1을 뺀다.

---
