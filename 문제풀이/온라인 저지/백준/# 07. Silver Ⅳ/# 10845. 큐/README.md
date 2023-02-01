# 문제
- 플랫폼 : 백준
- 번호 : 10845
- 제목 : 큐
- 난이도 : Silver 4
- 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리
- 문제 : <a href="https://www.acmicpc.net/problem/10845" target="_blank">링크</a>

---

# 필요 알고리즘
- 큐

---

# 풀이
```python
import sys

input = sys.stdin.readline

q = []
answer = []
for line in range(int(input())):
    command = list(input().rstrip().split())
    result = ''
    if command[0] == 'push':
        q.append(int(command[1]))
    elif command[0] == 'pop':
        answer.append(str(q.pop(0)) if q else '-1')
    elif command[0] == 'size':
        answer.append(str(len(q)))
    elif command[0] == 'empty':
        answer.append('0' if q else '1')
    elif command[0] == 'front':
        answer.append(str(q[0]) if q else '-1')
    else:
        answer.append(str(q[-1]) if q else '-1')

print('\n'.join(answer), end='')
```
- 큐 생성을 리스트로 했다.
- 주어진 지시대로 따르면 됨. 기본 큐 사용법을 익히는 예제

---
