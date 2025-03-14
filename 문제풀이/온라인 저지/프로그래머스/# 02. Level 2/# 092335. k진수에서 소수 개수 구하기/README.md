# 문제
- 플랫폼 : 프로그래머스
- 번호 : 092335
- 제목 : k진수에서 소수 개수 구하기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92335" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 수학
- 스택

---

# 풀이
```python
from math import sqrt

def solution(n, k):
    return len([num for num in split_numbers(n, k) if is_prime_number(num)])


# n진법 변환 후, 0이 아닌 숫자들 분리
def split_numbers(n, k):
    stack = [] # First In Last Out
    while n > 0:
        n, r = divmod(n, k)
        stack.append(r)
    cur = 0
    result = []
    while stack:
        head = stack.pop()
        if head != 0:
            cur *= 10
            cur += head
        elif cur != 0:
            result.append(cur)
            cur = 0
    if cur != 0:
        result.append(cur)
    return result


# 소수 여부 확인
def is_prime_number(n):
    if n == 1:
        return False
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True
```
- 숫자 변환
  - n 을 k 로 나눠가면서, 나머지를 stack에 쌓기
  - stack 을 역으로 꺼내면서, 0이 나오기 전까지 숫자를 계속 십진수로 변환하고, 결과 배열에 저장
- 위 과정을 통해 만들어진 배열을 순회하면서, 소수의 갯수 세기

---
