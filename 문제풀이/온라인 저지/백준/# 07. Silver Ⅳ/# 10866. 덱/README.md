# 문제
- 플랫폼 : 백준
- 번호 : 10866
- 제목 : 덱
- 난이도 : Silver 4
- 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리
- 문제 : <a href="https://www.acmicpc.net/problem/10866" target="_blank">링크</a>

---

# 필요 알고리즘
- 덱

---

# 풀이
```python
import sys

input = sys.stdin.readline

deq = []
answer = []
for line in range(int(input())):
    command = list(input().rstrip().split())
    result = ''
    if command[0] == 'push_front':
        deq.insert(0, command[1])
    elif command[0] == 'push_back':
        deq.append(command[1])
    elif command[0] == 'pop_front':
        answer.append(deq.pop(0) if deq else '-1')
    elif command[0] == 'pop_back':
        answer.append(deq.pop() if deq else '-1')
    elif command[0] == 'size':
        answer.append(str(len(deq)))
    elif command[0] == 'empty':
        answer.append('0' if deq else '1')
    elif command[0] == 'front':
        answer.append(deq[0] if deq else '-1')
    else:
        answer.append(deq[-1] if deq else '-1')

print('\n'.join(answer), end='')
```
- 리스트로 덱 구현

---
