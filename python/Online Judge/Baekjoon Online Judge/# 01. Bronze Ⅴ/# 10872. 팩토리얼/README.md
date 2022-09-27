# BOJ 10872 : 팩토리얼
- 난이도 : Bronze 5
- 팩토리얼 계산
- 문제 : [링크](https://www.acmicpc.net/problem/10872)

---  

## 풀이
```python
answer = 1

n = int(input())
for i in range(1, n+1):
    answer *= i
print(answer, end='')

```
- 재귀를 사용해 풀어도 되긴하는데, 순전히 특정 값의 팩토리얼만 구하면 되므로, 반복문으로 풀었다.

---
