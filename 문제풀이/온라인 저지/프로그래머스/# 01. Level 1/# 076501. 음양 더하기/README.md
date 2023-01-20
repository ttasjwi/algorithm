# 문제
- 플랫폼 : 프로그래머스
- 번호 : 076501
- 제목 : 음양 더하기
- 난이도 : Level 1
- 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어질 때
실제 정수들의 합을 구하여 return 
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/76501" target="_blank">링크</a>

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
def solution(absolutes, signs):
    return sum(absolutes if sign else -absolute
               for absolute, sign in zip(absolutes, signs))
```
- zip을 통해 두 배열을 엮을 수 있는 것을 처음 알았다.

---
