# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012973
- 제목 : 짝지어 제거하기
- 난이도 : Level 2
- 문자열에서 연속으로 반복되는 문자가 있으면 제거하길 반복하면서, 마지막에 문자열이 비는지 확인
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12973" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```python
def solution(s):
    stack = []
    for ch in s:
        if stack and stack[-1] == ch:
            stack.pop()
        else:
            stack.append(ch)
    return +(not stack)
```
- 문자를 스택에 계속 추가하다가, 같은 문자가 나오면 스택에서 문자를 제거한다.
- 마지막에 스택이 비어있으면 1, 비어있지 않으면 0 이다.
  - Python 기준 부울 앞에 + 를 붙이면 부울 값이 정수로 바뀐다.(True => 1, False => 0)

---
