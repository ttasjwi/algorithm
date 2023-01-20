# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012916
- 제목 : 문자열 내 p와 y의 개수
- 난이도 : Level 1
- s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12916)

---

# 필요 지식
- Python : 카운터

---

# 풀이
```python
from collections import Counter


def solution(s: str):
    counter = Counter(s.lower())
    return counter['p'] == counter['y']
```
- 문자열을 소문자화하고, Counter를 생성한다.
- 카운터 내의 'p' 카운트와, 'y' 카운트를 비교한다.

---
