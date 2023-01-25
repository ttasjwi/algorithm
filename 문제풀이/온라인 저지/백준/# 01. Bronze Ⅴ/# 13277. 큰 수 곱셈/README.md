# 문제
- 플랫폼 : 백준
- 번호 : 13277
- 제목 : 큰 수 곱셈
- 난이도 : Bronze 5
- 두 정수 A와 B가 주어졌을 때, 두 수의 곱을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13277" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이

## 풀이1
```python
a, b = map(int, input().split())
answer = a * b
print(answer, end='')
```
- 이 풀이로 통과는 된다.
- 하지만 느리다.

## 풀이2
```python
from decimal import getcontext, Decimal

getcontext().prec = 600000
a, b = map(Decimal, input().split())
answer = a * b
print(answer, end='')
```
- 두 수의 정밀도가 30만이므로, 곱에 대해서는 60만 정밀도를 지정한다.
- Decimal로 숫자를 받는다.
- 두 수의 곱을 구하고, 이 결과물을 출력한다.
- 빠르게 된다.

---
