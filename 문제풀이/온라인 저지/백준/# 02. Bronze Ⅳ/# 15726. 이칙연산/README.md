# 문제
- 플랫폼 : 백준
- 번호 : 15726
- 제목 : 이칙연산
- 난이도 : Bronze 4
- 나올 수 있는 가장 큰 값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15726" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a, b, c = map(int, input().split())
x = (a * b) / c
y = (a / b) * c
print(int(x) if x > y else int(y))
```
- 나머지 결과가 소수일 수 있으므로 실수나눗셈을 수행한다.
- 실수 나눗셈 결과 더 큰것을 정수화 시켜서 출력한다.

---
