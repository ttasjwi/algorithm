# 문제
- 플랫폼 : 백준
- 번호 : 09012
- 제목 : 괄호
- 난이도 : Silver 4
- 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9012" target="_blank">링크</a>

---

# 필요 알고리즘
- 스택

---

# 풀이

## 풀이1 : Stack 사용
```python
import io, os, sys

print = sys.stdout.write


def solution(line):
    stack = []

    for ch in line.rstrip():
        if ch == '(':
            stack.append(ch)
        elif not stack:
            return 'NO'
        else:
            stack.pop()

    return 'NO' if stack else 'YES'


answer = '\n'.join([solution(line) for line in sys.stdin.readlines()[1:]])
print(answer)
```
- 스택에 여는 괄호만 담고, 닫는 괄호가 들어올 때 꺼내는 방식
- 스택에 아무 것도 없는데 닫는 괄호가 들어오면 괄호가 맞지 않으므로 바로 NO 반환
- 끝까지 반복했는데 스택에 요소가 남아있으면 NO 반환, 있으면 YES 반환

## 풀이2 : 반복문 + replace
```python
import sys

print = sys.stdout.write


def solution(line):
    while '()' in line:
        line = line.replace('()', '')
    return 'NO' if line else 'YES'


answer = '\n'.join([solution(line.rstrip()) for line in sys.stdin.readlines()[1:]])
print(answer)
```
- 반복을 돌리면서 `()`을 `''`으로 변경
- 최종적으로 문자열이 빈 문자열이면 괄호가 맞고, 아니면 괄호가 맞지 않다.

---
