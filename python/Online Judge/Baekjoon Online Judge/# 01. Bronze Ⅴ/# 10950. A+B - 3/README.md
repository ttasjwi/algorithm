# BOJ 10950 : A+B - 3
- 난이도 : Bronze 5
- 반복적으로 두 수 합 구해 출력
- 문제 : [링크](https://www.acmicpc.net/problem/10950)

---  

## 풀이
```python
import sys

t = int(sys.stdin.readline().rstrip())

results = []

for i in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    sum = a+b
    results.append(sum)

print(*results, sep='\n', end='')
```
- 숫자를 반복적으로 입력받을 때는, 빠르게 입력받기 위해 `sys.stdin.readline().rstrip()`을 쓰면 좋다.
- `import sys`를 하면 된다

---
