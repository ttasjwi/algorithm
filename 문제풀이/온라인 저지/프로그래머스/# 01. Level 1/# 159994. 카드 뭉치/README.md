# 문제
- 플랫폼 : 프로그래머스
- 번호 : 159994
- 제목 : 카드 뭉치
- 난이도 : Level 1
- 원하는 단어 배열 goal이 매개변수로 주어질 때, cards1과 cards2에 적힌 단어들로 goal를 만들 수 있다면\
"Yes"를, 만들 수 없다면 "No"를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994 target="_blank">링크</a>

---

# 필요 지식
- 투 포인터

---

# 풀이
```python
from typing import List


def solution(cards1: List[str], cards2: List[str], goal: List[str]):
    p1 = 0
    p2 = 0
    for word in goal:
        if p1 < len(cards1) and cards1[p1] == word:
            p1 += 1
        elif p2 < len(cards2) and cards2[p2] == word:
            p2 += 1
        else:
            return "No"
    return "Yes"
```
- cards1의 포인터, cards2의 포인터를 하나씩 둔다.
- goal을 반복하면서 두 배열 포인터를 전진시켜가면서 진행한다. 어느 쪽에도 찾는 단어가 없다면 "No" 를 반환하면 된다.
- 끝까지 성공적으로 순회하면 "Yes"를 반환한다.

---
