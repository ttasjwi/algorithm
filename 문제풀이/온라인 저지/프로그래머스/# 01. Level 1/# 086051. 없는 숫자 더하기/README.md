# 문제
- 플랫폼 : 프로그래머스
- 번호 : 086051
- 제목 : 없는 숫자 더하기
- 난이도 : Level 1
- numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86051" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
def solution(numbers):
    return 45 - sum(numbers)
```
- 0부터 9까지 합은 45이고, 배열의 모든 요소를 빼면 없는 숫자의 합이다.

---
