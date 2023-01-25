# 문제
- 플랫폼 : 백준
- 번호 : 02163
- 제목 : 초콜릿 자르기
- 난이도 : Bronze 1
- 초콜릿의 크기가 주어졌을 때, 이를 1×1 크기의 초콜릿으로 쪼개기 위한 최소 쪼개기 횟수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2163" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n, m = map(int, input().split())
answer = m * n - 1
print(answer, end= '')
```
- 행동 관점에서 놓고보면, 가로를 (n-1)회 자르고, 세로를 n * (m-1) 회 자른다.
- `n-1 + n * (m-1) == m*n -1`이다.

---
