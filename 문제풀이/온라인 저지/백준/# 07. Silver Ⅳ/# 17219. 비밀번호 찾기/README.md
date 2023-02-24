# 문제
- 플랫폼 : 백준
- 번호 : 17219
- 제목 : 비밀번호 찾기
- 난이도 : Silver 4
- 비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17219" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())
dic = {}

for _ in range(n):
    site, pw = input().split()
    dic[site] = pw
for _ in range(m):
    print(dic[input().rstrip()])
    print('\n')
```
- 딕셔너리에 순서대로 저장하고, 그 다음 m개 줄은 각각 딕셔너리에서 찾아서 출력하면 된다.

---
