# BOJ 02439 : 별 찍기 - 2
- 난이도 : Bronze 4
- 조건에 맞게 별 찍기
- 문제 : [링크](https://www.acmicpc.net/problem/2439)

---  

## 풀이
```python
n = int(input())
for i in range(1, n+1):
    print(' '*(n-i), '*'*i,sep='')

```
- i번째 줄에는 n-i개의 공백과 i개의 별이 그려진다.

---
