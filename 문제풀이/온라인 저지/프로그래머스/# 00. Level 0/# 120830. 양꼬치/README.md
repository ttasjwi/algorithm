# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120830
- 제목 : 양꼬치
- 난이도 : Level 0
- 양꼬치와 음료수를 구입했을 때 실제 지불할 금액
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120830" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(n, k):
    return n * 12000 + (k - n//10) * 2000
```
- 음료수 증정은 음료수 구입 갯수를 10으로 나눈 몫만큼 지급되므로 해당금액만큼 차감해야한다.

---
