# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012944
- 제목 : 평균 구하기
- 난이도 : Level 1
- 정수를 담고 있는 배열 arr의 평균값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12944" target="_blank">링크</a>

---

# 필요 지식
- 단순 사칙 연산

---

# 풀이
```python
from typing import List


def solution(arr: List[int]):
    return sum(arr) / len(arr)

```
- sum 함수로 배열의 요소 합을 구하고 len으로 나눈다.

---
