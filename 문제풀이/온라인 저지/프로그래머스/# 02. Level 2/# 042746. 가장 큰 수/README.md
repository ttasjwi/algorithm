# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042746
- 제목 : 가장 큰 수
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42746" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
from functools import cmp_to_key


def solution(numbers):
    return str(int(''.join(sorted([str(number) for number in numbers], key=cmp_to_key(compare)))))


def compare(a, b):
    # 두 숫자 문자 a,b 을 앞 뒤로 붙임
    x = a + b
    y = b + a

    # a 를 앞에 붙인게 더 크면, a 를 앞으로 두기
    if x > y:
        return -1

    # b 를 앞에 붙인게 더 크면, b 를 앞으로 두기
    elif x < y:
        return 1
    else:
        return 0
```
- `functools.cmp_to_key` 를 쓰면, java 처럼 두 요소를 기준으로 비교할 수 있는 방법을 사용할 수 있다.
- 문자열 두 개를 앞뒤로 붙이는 식으로 했을 때 더 커지는 쪽으로 정렬할 수 있다.

---
