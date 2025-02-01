# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120831
- 제목 : 짝수의 합
- 난이도 : Level 0
- n 이하 모든 짝수의 합
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120831" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(n):
    return sum(range(2, n + 1, 2))
```
- sum 함수에는 iterable 을 전달할 수 있다.
- 2,4,6, ... n + 1 (미포함) 까지 2씩 증가하면서 반복하게 하면 된다.

---
