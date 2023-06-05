# 문제
- 플랫폼 : 백준
- 번호 : 01406
- 제목 : 에디터
- 난이도 : Silver 2
- 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1406" target="_blank">링크</a>

---

# 필요 지식
- 스택
- 연결리스트

---

# 풀이
## 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write
sl = list(input().rstrip())  # 커서 기준 왼쪽
sr = []  # 커서 기준 오른쪽에 있는 것들. 전체 문자열로 치면 제일 뒤의 문자가 맨 앞에 위치한다

for _ in range(int(input())):
    line = input().rstrip().split()
    command = line[0]
    ch = None if len(line) == 1 else line[1]

    if command == 'L':
        # 커서 왼쪽 이동 -> 왼쪽 요소 맨 끝 문자가 오른쪽 맨 앞이 됨
        if sl:
            sr.append(sl.pop())
    elif command == 'D':
        # 커서 오른쪽 이동 -> 오른쪽 요소 맨 앞이 왼쪽요소 맨 뒤가 됨
        if sr:
            sl.append(sr.pop())
    elif command == 'B':
        # 커서 왼쪽 요소 삭제 -> 왼쪽요소 맨뒤 문자 제거
        if sl:
            sl.pop()
    elif command == 'P':
        # 커서 오른쪽에 문자 삽입 -> sl 뒤에 문자 추가
        sl.append(ch)

print(''.join(sl))
print(''.join(sr[::-1]))
```
- 커서 기준 왼쪽 문자들을 왼쪽 스택에 몰아넣는다.
- 커서 기준 오른쪽 문자들은 오른쪽 스택에 거꾸로 몰아넣는다. 오른쪽 스택을 놓고보면 제일 뒤의 문자는 스택 최심부에 위치하고, 제일 앞의 문자는 스택 입구쪽에 위치한다.
- 커서 왼쪽 이동: 왼쪽 스택 맨 뒤 문자를 오른쪽 맨앞으로 이동
- 커서 오른쪽 이동 : 오른쪽 스택 맨 앞이 왼쪽 스택 맨 뒤로 이동
- 커서 왼쪽 요소 삭제 : 왼쪽 스택 맨 뒤의 문자를 제거
- 커서 오른쪽 문자 삽입 : 왼쪽 스택 맨 뒤에 문자를 추가
- 그 후, 왼쪽 스택은 맨 앞부터 차례로 출력하고, 오른쪽 스택은 역순으로 출력하면 된다.

---
