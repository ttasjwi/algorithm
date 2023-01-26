# 문제
- 플랫폼 : 백준
- 번호 : 02441
- 제목 : 별 찍기 - 4
- 난이도 : Bronze 3
- 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/2441" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = '\n'.join(' ' * i + '*' * (n-i) for i in range(n))
print(answer, end='')
```
- i(0,1,2,3, ...)번째 라인에는 i개의 공백, (n-i)개의 별이 존재한다.

---
