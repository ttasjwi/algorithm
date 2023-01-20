# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012922
- 제목 : 수박수박수박수박수박수?
- 난이도 : Level 1
- "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12922" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(n):
    return ''.join(['수박'[i % 2] for i in range(n)])
```
- 리스트 컴프리헨션을 이용한 조합

---
