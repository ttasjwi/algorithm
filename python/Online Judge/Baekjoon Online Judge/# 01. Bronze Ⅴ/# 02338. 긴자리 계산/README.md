# BOJ 02338 : 긴자리 계산
- 난이도 : Bronze 5
- 큰 범위의 숫자를 합하라는 문제
- 문제 : [링크](https://www.acmicpc.net/problem/2338)

---  

## 풀이
```python
a = int(input())
b = int(input())
print(a+b, a-b, a*b, sep='\n', end='')

```
- 파이썬은 큰 숫자도 int로 담을 수 있음
- 그냥 합, 차, 곱 구해서 출력하면 된다.

---
