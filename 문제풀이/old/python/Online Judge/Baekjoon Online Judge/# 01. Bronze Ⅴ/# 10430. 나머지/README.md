# BOJ 10430 : 나머지
- 난이도 : Bronze 5
- 시키는 대로 계산한 결과 그대로 출력하는 문제
- 문제 : [링크](https://www.acmicpc.net/problem/10430)

---  

## 풀이
```python
a, b, c = map(int, input().split())
result = (
    (a + b) % c,
    ((a % c) + (b % c)) % c,
    (a * b) % c,
    ((a % c) * (b % c)) % c
)
print(*result, sep='\n', end='')


```
- 튜플에 결과를 순서대로 저장하고 전개 연산자를 통해 풀어서 출력했다.

---
