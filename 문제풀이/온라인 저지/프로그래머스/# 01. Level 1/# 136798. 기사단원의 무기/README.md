# 문제
- 플랫폼 : 프로그래머스
- 번호 : 136798
- 제목 : 기사단원의 무기
- 난이도 : Level 1
- 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/136798" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
from math import sqrt


def solution(number, limit, power):
    attacks = [0] * (number + 1)
    for i in range(1, number + 1):
        for j in range(1, int(sqrt(i)) + 1):
            if i % j == 0:
                attacks[i] += 2 if i // j != j else 1
    return sum(power if attack > limit else attack for attack in attacks[1:])
```
- 각각의 약수 판별시 자기 자신의 거듭제곱근까지만 판단한다.
- 제곱수의 경우 1번 더하고, 제곱수가 아니면 두번 더한다.
- 이렇게 약수의 갯수를 구하고, 문제에서 주어진 조건에 따라 합산하면 된다.

---
