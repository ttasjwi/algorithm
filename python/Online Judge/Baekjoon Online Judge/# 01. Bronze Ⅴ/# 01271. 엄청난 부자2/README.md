# BOJ 01271 : 엄청난 부자2
- 난이도 : Bronze 5
- 몫, 나머지
- 문제 : [링크](https://www.acmicpc.net/problem/1271)

---  

## 풀이
```python
n, m = map(int, input().split())
answer1, answer2 = n // m, n % m
print(answer1, answer2, sep='\n', end='')

```
- n, m 을 입력받고, 몫, 나머지를 출력
- 숫자 범위가 크긴 한데 파이썬은 정수 타입이 하나뿐이라서 문제 없다.

---
