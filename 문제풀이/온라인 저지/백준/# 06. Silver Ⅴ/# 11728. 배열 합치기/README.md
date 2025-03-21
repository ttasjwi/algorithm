# 문제
- 플랫폼 : 백준
- 번호 : 11728
- 제목 : 배열 합치기
- 난이도 : Silver 5
- 문제 : <a href="https://www.acmicpc.net/problem/11728" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')
print = sys.stdout.write

n, m = map(int, lines[0].split())
a = list(map(int, lines[1].split()))
b = list(map(int, lines[2].split()))

p1 = 0
p2 = 0

result = []
while p1 < n and p2 < m:
    if a[p1] <= b[p2]:
        result.append(str(a[p1]))
        p1 += 1
    else:
        result.append(str(b[p2]))
        p2 += 1

while p1 < n:
    result.append(str(a[p1]))
    p1 += 1

while p2 < m:
    result.append(str(b[p2]))
    p2 += 1
print(' '.join(result))
```
- 정렬된 배열 두개에 포인터를 두고 비교해나가면서, 배열을 병합한다.

---
