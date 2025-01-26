# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120829
- 제목 : 배열의 평균값
- 난이도 : Level 0
- 배열의 평균값
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120829" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(angle):
    if angle == 180:
        return 4
    elif angle > 90:
        return 3
    elif angle == 90:
        return 2
    else:
        return 1
```
- 분기처리

---
