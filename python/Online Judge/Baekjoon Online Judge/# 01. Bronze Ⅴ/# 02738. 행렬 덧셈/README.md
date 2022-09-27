# BOJ 02738 : 행렬 덧셈
- 난이도 : Bronze 5
- 리스트 컴프리헨션을 활용하여 입력받고, 행렬 합 구하기
- 문제 : [링크](https://www.acmicpc.net/problem/2738)

---  

## 풀이
```python
import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

list1 = [[int(x) for x in input().split()] for _ in range(n)]
list2 = [[int(x) for x in input().split()] for _ in range(n)]
result = [[list1[i][j] + list2[i][j] for j in range(m)] for i in range(n)]

for row in result:
    print(' '.join(str(element) for element in row))

```
- 리스트 컴프리헨션을 연습하기 좋음.

---
