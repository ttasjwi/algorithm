# 문제
- 플랫폼 : LeetCode
- 번호 : 0020
- 제목 : Valid Parentheses
- 난이도 : Easy
- 괄호가 올바른 순서대로 되어 있는 지 확인
- 문제 : <a href="https://leetcode.com/problems/valid-parentheses" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```python
class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        stack = []
        for ch in s:
            if ch not in pairs:
                stack.append(ch)
            elif not stack or pairs[ch] != stack.pop():
                return False

        return not stack
```
- pairs : 닫는 괄호의 짝을 저장
- stack : 괄호를 담는 stack
- 문자열을 읽어가면서 반복
  - 여는 괄호이면 stack에 삽입
  - 그 외에는 모두 닫는 괄호인데, 스택이 비어있거나 스택 최상단 요소가 짝이 안 맞으면 False
- 끝까지 순회했을 때 스택이 비어있지 않으면 False, 그 외에는 True

---
