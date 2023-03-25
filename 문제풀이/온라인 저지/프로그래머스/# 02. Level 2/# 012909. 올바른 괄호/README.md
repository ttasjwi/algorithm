# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012909
- 제목 : 올바른 괄호
- 난이도 : Level 2
- 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12909" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```python
def solution(s):
    stack = []
    for ch in s:
        if ch == '(':
            stack.append(ch)
        elif not stack or stack[-1] == ch:
            return False
        else:
            stack.pop()
    return False if stack else True
```
- 스택을 통해 문자열의 유효성을 검사함

---
