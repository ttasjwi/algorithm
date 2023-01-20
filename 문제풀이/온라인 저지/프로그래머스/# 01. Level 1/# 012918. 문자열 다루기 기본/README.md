# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012918
- 제목 : 문자열 다루기 기본
- 난이도 : Level 1
- s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12918" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(s):
    return s.isnumeric() and len(s) in [4, 6]
```
- 숫자로만 구성되어 있는지 : isnumeric
- ~ 중 하나인지 : `in [...]`

---
