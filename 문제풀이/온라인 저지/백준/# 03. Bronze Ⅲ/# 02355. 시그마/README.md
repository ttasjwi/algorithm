# 문제
- 플랫폼 : 백준
- 번호 : 02355
- 제목 : 시그마
- 난이도 : Bronze 3
- 두 정수 A와 B가 주어졌을 때, 두 정수 사이에 있는 수의 합 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2355" target="_blank">링크</a>

---

# 필요 알고리즘
- 등차수열의 합

---

# 풀이
```python
a, b = map(int, input().split())
answer = (abs(b - a) + 1) * (a + b) // 2
print(answer, end='')
```

---
