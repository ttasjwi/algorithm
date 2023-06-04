# 문제
- 플랫폼 : 백준
- 번호 : 02935
- 제목 : 소음
- 난이도 : Bronze 3
- 입력된 피연산자, 연산자를 토대로 A+B 또는 A*B 계산
- 문제 : <a href="https://www.acmicpc.net/problem/2935" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a = int(input())
op = input()
b = int(input())
print(a + b if op == '+' else a * b)

```
- 파이썬 - 정수타입의 범위에 대해 크게 고려하지 않고, int 타입으로 취급
- 연산자가 '+' 이면 덧셈, 그렇지 않으면 곱셈

---