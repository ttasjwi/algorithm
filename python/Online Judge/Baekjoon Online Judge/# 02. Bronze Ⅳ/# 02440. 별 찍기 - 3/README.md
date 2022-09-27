# BOJ 02440 : 별 찍기 - 3
- 난이도 : Bronze 4
- 요구사항 대로 별 찍기
- 문제 : [링크](https://www.acmicpc.net/problem/2440)

---  

## 풀이
```python
n = int(input())

for i in range(1, n+1):
    print('*' * (n+1 - i))

```
- i번째 줄에는 n+1 - i 개의 별이 삽입되는 규칙성을 파악하고, 그대로 별을 출력하면 된다.

---
