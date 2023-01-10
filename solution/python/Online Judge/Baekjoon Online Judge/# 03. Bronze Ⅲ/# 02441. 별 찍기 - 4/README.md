# BOJ 02441 : 별 찍기 - 4
- 난이도 : Bronze 3
- 요구사항에 맞게 별 찍기
- 문제 : [링크](https://www.acmicpc.net/problem/2441)

---  

## 풀이
```python
n = int(input())
for i in range(n):
    print(' ' * i, '*'*(n-i), sep='')

```
- 시작점을 1로 잡으면 연산해야할 양이 미세하게 늘어나서 0을 시작점으로 잡았다.
- i 라인에서는 공백이 i개, '*'이 n-i개 존재

