# 문제
- 플랫폼 : 프로그래머스
- 번호 : 077884
- 제목 : 약수의 개수와 덧셈
- 난이도 : Level 1
- left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77884" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이

파이썬으로 풀었다.

## 풀이1 : 순수하게 약수 전부 카운팅
```python
def solution(left, right):
    counts = [0, 1, *([2]*(right-1))]

    for i in range(2, right + 1):
        for j in range(2 * i, right + 1, i):
            counts[j] += 1

    return sum(i if counts[i] % 2 == 0 else -i
               for i in range(left, right + 1))

```
- 1,2, ... right까지 모든 수의 약수들을 카운팅한다.
- left부터 right까지 반복하여 각각의 값마다 약수의 갯수가 짝수이면 해당 값을 더하고, 홀수이면 해당 값을 뺀다.

## 풀이2 : 제곱수의 약수는 홀수개이다!!!
```python
from math import sqrt


def solution(left, right):
    return sum(i if sqrt(i) % 1 else -i
               for i in range(left, right + 1))
```
- 어떤 수가 제곱수(스스로의 거듭제곱근이 정수인 수)이면 해당 수의 약수의 갯수는 무조건 홀수다.
  - 제곱수 여부를 `sqrt(i)%1`로 판단했는데, 이 값이 0이 아니면 Truthy하므로 참으로 평가된다.
- 이 성질을 이용하면 left부터 right까지만 순회하면 된다.

---
