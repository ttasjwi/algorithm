# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012931
- 제목 : 자릿수 더하기
- 난이도 : Level 1
- N의 각 자릿수의 합을 구해서 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12931" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
def solution(n):
    sum = 0
    while n:
        n, r = divmod(n, 10)
        sum += r
    return sum
```
- 10으로 나눠가면서, 나머지를 계속 더하기

---
