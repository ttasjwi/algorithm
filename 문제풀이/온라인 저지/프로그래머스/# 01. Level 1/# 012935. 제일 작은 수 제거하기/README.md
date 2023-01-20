# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012935
- 제목 : 제일 작은 수 제거하기
- 난이도 : Level 1
- arr 에서 가장 작은 수를 제거한 배열을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12935" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
from typing import List


def solution(arr:List[int]):
    arr.remove(min(arr))
    return arr if arr else [-1]


```
