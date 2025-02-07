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
        # 뽑은 문자가 여는 괄호면 스택에 삽입
        if ch == '(':
            stack.append(ch)
        else:
            # 뽑은 문자가 닫는 괄호인데 스택이 비어져 있다면 올바르지 않음
            if not stack:
                return False
            stack.pop()
    # 마지막에 스택이 비어져 있어야 함
    return not len(stack)
```

---
