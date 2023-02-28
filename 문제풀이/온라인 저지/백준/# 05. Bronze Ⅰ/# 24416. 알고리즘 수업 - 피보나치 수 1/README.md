# 문제
- 플랫폼 : 백준
- 번호 : 24416
- 제목 : 알고리즘 수업 - 피보나치 수 1
- 난이도 : Bronze 1
- 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인
- 문제 : <a href="https://www.acmicpc.net/problem/24416" target="_blank">링크</a>

---

# 필요 알고리즘
- 다이나믹 프로그래밍

---
# 풀이
```python
n = int(input())

first, second = 1, 1
for i in range(3, n + 1):
    first, second = second, first + second
print(second, n-2)
```
- 재귀함수를 호출하는 방식에서, 재귀 함수를 fib(n)이라 하면
  - n>=3 일 때 fib(n)에서 코드1을 호출하는 횟수는 fib(n-1)에서 코드1을 호출하는 횟수와 fib(n-2)에서 코드1을 호출하는 횟수의 합과 같다.
- 다이나믹 프로그래밍 방식에서는 결국 반복문의 해당 라인을 실행하는 횟수가 코드2를 실행하는 횟수와 같아지는데
  - n>=3 일때 코드2를 호출하는 횟수는 n-2와 같다.

---
