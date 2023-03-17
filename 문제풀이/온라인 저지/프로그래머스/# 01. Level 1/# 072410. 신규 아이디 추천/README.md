# 문제
- 플랫폼 : 프로그래머스
- 번호 : 72410
- 제목 : 신규 아이디 추천
- 난이도 : Level 1
- 7단계의 처리 과정을 거친 후의 추천 아이디를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72410" target="_blank">링크</a>

---

# 필요 지식
- 정규 표현식

---

# 풀이
```python
import re

def solution(id: str):
    # 1단계
    id = id.lower()

    # 2단계
    id = re.sub(r'[^0-9a-z-_.]', '', id)

    # 3단계
    id = re.sub(r'\.{2,}', '.', id)

    # 4단계
    id = re.sub(r'^\.|\.$', '', id)

    # 5단계
    id = 'a' if id == '' else id

    # 6단계
    if len(id) < 16:
        pass
    else:
        id = id[:15]
        if id[-1] == '.':
            id = id[:-1]
    

    # 7단계
    if len(id) <= 2:
        end = id[-1]
        id += end * (3 - len(id))
    return id
```
- 정규 표현식을 적극적으로 사용해서 문제를 해결했다.

---
