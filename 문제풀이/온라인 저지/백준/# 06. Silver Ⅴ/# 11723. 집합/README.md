# 문제
- 플랫폼 : 백준
- 번호 : 11723
- 제목 : 집합
- 난이도 : Silver 5
- check 연산이 주어질때마다, 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11723" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

m = int(input())
s = set()
nums = set(str(i) for i in range(1, 21))
for _ in range(m):
    line = input().split()
    if line[0] == "add":
        s.add(line[1])
    elif line[0] == "remove":
        if line[1] in s:
            s.remove(line[1])
    elif line[0] == "check":
        print('1' if line[1] in s else '0')
        print('\n')
    elif line[0] == "toggle":
        if line[1] in s:
            s.remove(line[1])
        else:
            s.add(line[1])
    elif line[0] == 'all':
        s = nums.copy()
    elif line[0] == 'empty':
        s.clear()
```
- set 자료형에 대한 기본 사용법을 알면 쉽게 풀 수 있는 문제다.

---
