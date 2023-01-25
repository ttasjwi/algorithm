# 문제
- 플랫폼 : 백준
- 번호 : 03046
- 제목 : R2
- 난이도 : Bronze 4
- 두 정수 R1과 S가 주어질 때 R2 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/3046" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
r1, s = map(int, input().split())
answer = 2 * s - r1
print(answer, end='')
```
- `r1 + r2 // 2`가 s이므로, 역으로 r2를 구할 수 있다.

---
