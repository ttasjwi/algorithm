# 문제
- 플랫폼 : 백준
- 번호 : 02985
- 제목 : 세 수
- 난이도 : Bronze 3
- 첫째 줄에 정인이가 원래 적어준 등식을 출력하라. 입력으로 주어진 숫자의 순서는 유지해야 하고, 등호 하나와 더하기, 빼기, 곱하기, 나누기 기호 중 하나로 이루어져 있어야 한다.
만약 등식이 여러 가지가 나올 수 있다면, 그 중 하나만 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2985" target="_blank">링크</a>

---

# 필요 지식
- 많은 조건 분기

---

# 풀이
## 풀이1: 조건분기
```python
a, b, c = map(int, input().split())

if a + b == c:
    print(f'{a}+{b}={c}')
elif a - b == c:
    print(f'{a}-{b}={c}')
elif a * b == c:
    print(f'{a}*{b}={c}')
elif a // b == c:
    print(f'{a}/{b}={c}')
elif a == b + c:
    print(f'{a}={b}+{c}')
elif a == b - c:
    print(f'{a}={b}-{c}')
elif a == b * c:
    print(f'{a}={b}*{c}')
else:
    print(f'{a}={b}/{c}')
```
- 나올 수 있는 케이스는 모두 8가지이므로 각각에 대해 if문을 작성한다

## 풀이2: eval 활용
```python
operators = ['+', '-', '*', '/']
a, b, c = input().split()

for op in operators:
    if eval(f'{a}{op}{b}') == int(c):
        print(f'{a}{op}{b}={c}')
        exit(0)
    elif int(a) == eval(f'{b}{op}{c}'):
        print(f'{a}={b}{op}{c}')
        exit(0)
```
- eval 함수는 문자열을 파이썬의 표현식으로서 인식하고 평가하는데, 이를 이용하여 1번 풀이를 간소화 시킬 수 있다.

---
