# BOJ 02442 : 별 찍기 - 5
- 난이도 : Bronze 3
- 요구사항에 맞게 별 찍기
- 문제 : [링크](https://www.acmicpc.net/problem/2442)

---  

## 풀이
```python
n = int(input())
for i in range(1, n + 1):
    print(' ' * (n - i), '*' * (2 * i - 1), sep='')

```
- 1,2, ... n까지 반복
- i번 라인에는 n-i개의 공백, (2*i - 1)개의 별

---
