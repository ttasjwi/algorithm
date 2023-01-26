# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012921
- 제목 : 소수 찾기
- 난이도 : Level 1
- 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12921" target="_blank">링크</a>

---

# 필요 지식
- 에라토스테네스의 체

---

# 풀이
```python
from math import sqrt


def solution(n):
    check = [False, True] + [False] * (n - 1)
    for i in range(2, int(sqrt(n)) + 1):
        if not check[i]:
            for j in range(2 * i, n + 1, i):
                check[j] = True
    return len([c for c in check[1:] if not c])
```
- 에라토스테네스의 체 알고리즘을 적용할 때도, 거듭제곱근까지만 소수체크를 해도 된다.

---
