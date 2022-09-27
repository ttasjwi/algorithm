# BOJ 03733 : Shares
- 난이도 : Bronze 5
- 주를 여러명이 균등하게 나눴을 때 각 사람이 받을 수 있는 최대 배당주
- 문제 : [링크](https://www.acmicpc.net/problem/3733)

---  

## 문제 해석
- N persons and the ACM Chief : n+1명이 나눠먹는다는 뜻이다
- group : 

## 풀이
```python
import sys

for line in sys.stdin:
    n, s = map(int, line.split())
    print(s//(n+1))


```
- n, s 를 입력받고 라인마다 `s//n+1`를 출력하면 됨

---
