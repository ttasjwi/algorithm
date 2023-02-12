# 문제
- 플랫폼 : 백준
- 번호 : 07785
- 제목 : 회사에 있는 사람
- 난이도 : Silver 5
- 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7785" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

s = set()
for _ in range(int(input())):
    x, y = input().split()
    if y == 'enter':
        s.add(x)
    else:
        s.remove(x)
print('\n'.join(sorted(s, reverse=True)))
```
- enter 문자열이 있으면 set에 삽입
- 없으면 remove
- 정렬된 리스트로 변경 후 출력

---
