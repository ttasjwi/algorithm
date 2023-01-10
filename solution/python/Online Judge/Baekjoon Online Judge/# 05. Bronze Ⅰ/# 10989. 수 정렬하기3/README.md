# BOJ 10989 : 수 정렬하기 3
- 난이도 : Bronze 1
- 많은 숫자를 정렬
- 문제 : [링크](https://www.acmicpc.net/problem/10989)

---  

## 풀이
```python
from sys import stdin, stdout

input = lambda: stdin.readline().rstrip()
print = stdout.write

n = int(input())
counter = [0] * 10_001

for _ in range(n):
    number = int(input())
    counter[number] += 1

for i in range(1, 10_001):
    if counter[i] > 0:
        while counter[i] > 1000:
            print((str(i) + '\n') * 1000)
            counter[i] -= 1000
        print((str(i) + '\n') * counter[i])

```
- 메모리 초과, 시간 초과가 엄청 곤란하다.
- 이런 문제는 이렇게 풀 바에... 차라리 java 등으로 푸는게 나을 것 같다.

---
