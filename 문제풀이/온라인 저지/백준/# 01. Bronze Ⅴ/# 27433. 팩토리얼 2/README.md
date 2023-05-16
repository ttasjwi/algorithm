# 문제
- 플랫폼 : 백준
- 번호 : 27433
- 제목 : 팩토리얼 2
- 난이도 : Bronze 5
- N!을 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/27433" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이

## 풀이1 : math.factorial
```python
import math

print(math.factorial(int(input())))
```

## 풀이2: 직접 팩토리얼 구하기
```python
answer= 1
for i in range(1, int(input()) + 1):
    answer *= i
print(answer)
```
- 직접 팩토리얼 값을 구한다.

---
