# 문제
- 플랫폼 : 백준
- 번호 : 02774
- 제목 : 아름다운 수
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/2774" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write
answer = []

t = int(input())

for i in range(t):
    answer.append(str(len(set(input().rstrip()))))
print('\n'.join(answer))
```
- 매 입력을 set 으로 변환후 문자 갯수를 세서, answer 에 append
- 출력

---
