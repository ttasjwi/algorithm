# BOJ 10869 : 사칙연산
- 난이도 : Bronze 5
- 사칙연산
- 문제 : [링크](https://www.acmicpc.net/problem/10869)

---

## 풀이
```python
a, b = map(int, input().split())
print(a + b, a - b, a * b, a // b, a % b, sep='\n')

```
- 키워드 매개변수 기능을 이용해, 마지막에 `sep`를 통해 구분자를 개행문자로 지정해서 출력했다.

---
