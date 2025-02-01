# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120816
- 제목 : 피자 나눠 먹기 (3)
- 난이도 : Level 0
- 피자를 최소 한 조각씩 나눠 먹을 수 있도록 하는 피자 판수
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120816" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(slice, n):
    q, r = divmod(n, slice)
    return q if r == 0 else q + 1
```
