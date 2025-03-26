# 문제
- 플랫폼 : 백준
- 번호 : 18311
- 제목 : 왕복
- 난이도 : Silver 5
- 문제 : <a href="https://www.acmicpc.net/problem/18311" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

n, k = map(int, input().split())
lengths = list(map(int, input().split()))

start = 0
answer = None
for i in range(len(lengths)):
    end = start + lengths[i]
    if k < end:
        answer = i + 1
        break
    start = end

if not answer:
    for i in range(len(lengths)-1, -1, -1):
        end = start + lengths[i]
        if k < end:
            answer = i + 1
            break
        start = end
print(str(answer))
```
