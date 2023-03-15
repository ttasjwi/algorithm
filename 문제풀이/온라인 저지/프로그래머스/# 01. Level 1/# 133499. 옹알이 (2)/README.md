# 문제
- 플랫폼 : 프로그래머스
- 번호 : 133499
- 제목 : 옹알이 (2)
- 난이도 : Level 1
- 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/133499" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
from typing import List


def solution(babbling: List[str]):
    answer = 0
    for i in range(len(babbling)):
        babbling[i] = babbling[i].replace("aya", "1").replace("ye", "2").replace("woo", "3").replace("ma", "4")
        if check(babbling[i]):
            answer += 1
    return answer


def check(word):
    before = ''
    for ch in word:
        if ch == before or ch.isalpha():
            return False
        before = ch
    return True
```
- 문자열에서 babbling에 해당하는 단어들을 전부 숫자 문자열로 바꾼다.
  - 이제, babbling에 해당하지 않는 단어들만 영소문자 문자열이다.
- 각 단어의 문자를 순서대로 탐색하며, 이전 문자와 같거나, 알파벳인 경우 발음할 수 없는 단어로 취급한다.

---
