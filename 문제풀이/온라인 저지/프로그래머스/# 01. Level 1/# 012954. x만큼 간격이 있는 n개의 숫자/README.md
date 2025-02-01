# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012954
- 제목 : x만큼 간격이 있는 n개의 숫자
- 난이도 : Level 1
- 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12954" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
def solution(x, n):
    return [x * i for i in range(1, n+1)]

```
- n개짜리 배열을 만들어야하는데, 각 항이 x의 배수이다.
- 파이썬을 사용할 경우 리스트 컴프리헨션으로 간단하게 만들 수 있다.

---
