# BOJ 04101 : 크냐?
- 난이도 : Bronze 5
- 여러 라인에 걸쳐 들어오는 두 수들의 대소관계를 순서대로 비교
- 문제 : [링크](https://www.acmicpc.net/problem/4101)

---  

## 풀이
```python
import sys

while True:
    a, b = map(int, sys.stdin.readline().rstrip().split())

    if a == b == 0:
        break
    print('Yes' if a > b else 'No')
```
- a, b가 0이면 반복 멈춤
- `a > b`이면 Yes, 아니면 No

---
