# 문제

- 플랫폼 : 프로그래머스
- 번호 : 012934
- 제목 : 정수 제곱근 판별
- 난이도 : Level 1
- n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12934)

---

# 필요 지식
- 수학

---

# 풀이
```python
from math import sqrt


def solution(n):
    float_sqrt = sqrt(n)
    int_sqrt = int(float_sqrt)

    return (int_sqrt + 1) ** 2 if float_sqrt == int_sqrt else -1
```
- float_sqrt : 실수 제곱근
- int_sqrt : 정수화
- 두 값이 같으면 정수 제곱근이라는 뜻이고, +1 해서 제곱한 값 반환. 같지 않으면 -1 반환

---
