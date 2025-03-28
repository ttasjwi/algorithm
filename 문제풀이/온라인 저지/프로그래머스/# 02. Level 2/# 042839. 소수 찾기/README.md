# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042839
- 제목 : 소수 찾기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42839" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 에라토스테네스의 체
- DFS

---

# 풀이
```python
from math import sqrt


def solution(numbers):
    s = set()
    check = [False] * len(numbers)
    max_num = -1

    def dfs(idx, value):
        nonlocal max_num, check
        for i in range(len(numbers)):
            if idx == 0 and numbers[i] == '0':
                continue
            if not check[i]:
                check[i] = True
                next_value = value * 10 + ord(numbers[i]) - ord('0')
                if next_value > max_num:
                    max_num = next_value
                s.add(next_value)
                if idx != len(numbers) - 1:
                    dfs(idx + 1, next_value)
                check[i] = False

    dfs(0, 0)

    is_prime_number = [True] * (max_num + 1)
    is_prime_number[0], is_prime_number[1] = False, False
    if 1 in s:
        s.remove(1)
    for i in range(2, int(sqrt(max_num)) + 1):
        if is_prime_number[i]:
            for j in range(2 * i, max_num + 1, i):
                is_prime_number[j] = True
                if j in s:
                    s.remove(j)
    return len(s)
```
- 숫자들을 전부 순회하면서 조합들을 전부 구하고 set 에 추가
- set 에서 가장 큰 숫자를 기준으로 하여 에라토스테네스의 체 적용 -> 소수만 남기고 필러팅
- 남은 숫자의 갯수를 반환

---
