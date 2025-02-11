# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042578
- 제목 : 의상
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42578" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
from collections import Counter

def solution(clothes):
    counter = Counter([kind for _, kind in clothes])
    answer = 1
    for v in counter.values():
        answer *= (v + 1)
    return answer - 1
```
- 종류별로 카운팅(counter)
- 카운터의 value를 순회하면서, 곱함(독립이므로 곱의 법칙, 선택 안 하는 경우도 있으므로 +1 해서 곱함)
- 아무것도 안 입은 경우는 제해야하므로 1 차감
- 반환

---
