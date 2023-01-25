# 문제
- 플랫폼 : 프로그래머스
- 번호 : 132267
- 제목 : 콜라 문제
- 난이도 : Level 1
- 상빈이가 받을 수 있는 콜라의 병 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132267" target="_blank">링크</a>

---

# 필요 지식
- 나머지 연산

---

# 풀이
```python
def solution(a, b, cola):
    answer = 0

    while cola >= a:
        cola, remainder = cola // a * b, cola % a
        answer += cola
        cola = cola + remainder

    return answer
```
- 반복 조건 : 우선 콜라를 교환할 수 있으려면 콜라의 갯수는 a개보다 같거나 많아야한다.
  1. cola : 기존 콜라를 a로 라눈 몫 * b개 
  2. remainder: 기존 콜라를 a로 나눈 나머지
  3. answer 증가 : cola만큼 증가
  4. cola : 다시 cola와 remainder를 합산하여 다음 연산을 할 수 있도록 한다.

---
