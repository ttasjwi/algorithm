# 문제
- 플랫폼 : 백준
- 번호 : 02442
- 제목 : 별 찍기 - 5
- 난이도 : Bronze 3
- 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/2442" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = '\n'.join(' ' * (n - i) + '*' * (2 * i - 1) for i in range(1, n + 1))
print(answer, end='')
```
- i(1,2,3,4,5, ...)번째 줄에는 공백이 n-i개, 별이 (2*i -1)개 존재한다.

---
