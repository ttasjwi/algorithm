# 문제
- 플랫폼 : 프로그래머스
- 번호 : 070128
- 제목 : 내적
- 난이도 : Level 1
- 내적 `a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]`을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/70128" target="_blank">링크</a>

---

# 필요 알고리즘
- Python : 리스트 컴프리헨션, zip

---

# Python
```python
def solution(numbers_a, numbers_b):
    return sum(a * b for a, b in zip(numbers_a, numbers_b))
```
- zip 을 사용하여 두 리스트를 엮을 수 있다.

---
