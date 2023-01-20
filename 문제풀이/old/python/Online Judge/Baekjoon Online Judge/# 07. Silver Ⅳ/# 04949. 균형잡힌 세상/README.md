# BOJ 04949 : 균형잡힌 세상

- 난이도 : Silver 4
- 라인마다 괄호 맞는지 여부 판단  
- 문제 : [링크](https://www.acmicpc.net/problem/4949)

---

## 풀이
```python
from sys import stdin, stdout

stack = []


def main():
    lines = stdin.readlines()
    lines.pop()
    for line in lines:
        stdout.write('yes\n' if is_valid_line(line) else 'no\n')


def is_valid_line(line):
    stack.clear()
    for char in line:
        if char in '[(':
            stack.append(char)
        elif char == ']':
            if len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            else:
                return False
        elif char == ')':
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                return False
    return not stack


main()
```
- 괄호가 맞는지 여부를 판단하는 문제는 스택을 쓰는 것이 편하다.
- 문자를 읽어가면서, 여는 괄호를 스택에 삽입하고, 닫는 괄호를 만나면 pop한다.
  - 여는 괄호가 없는데 닫는 괄호가 추가되면 안 맞는 것이다.
  - 끝까지 스택에 무언가 요소가 남아있으면, 안 맞는 것이다.

---
