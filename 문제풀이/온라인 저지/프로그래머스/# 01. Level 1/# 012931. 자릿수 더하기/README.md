# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012931
- 제목 : 자릿수 더하기
- 난이도 : Level 1
- 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12931)

---

# 필요 지식
- 나머지 연산

---

# 풀이
```python
def solution(n):
    answer = 0
    while n > 0:
        answer += n % 10
        n //= 10

    return answer
```
- 10으로 나눠가면서 나머지를 answer 에 누산

---
