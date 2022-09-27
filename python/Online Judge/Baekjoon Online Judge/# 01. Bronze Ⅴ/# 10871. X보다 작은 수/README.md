# BOJ 10871 : X보다 작은 수
- 난이도 : Bronze 5
- 숫자들 입력받고, 지정 값보다 작은 값들만 출력
- 문제 : [링크](https://www.acmicpc.net/problem/10871)

---  

## 풀이
```python
import sys

input = lambda: sys.stdin.readline().rstrip()
n, x = map(int, input().split())
result = [k for k in input().split() if int(k) < x]
print(*result, end='')

```
- 리스트 컴프리헨션을 활용해 필터링

---
