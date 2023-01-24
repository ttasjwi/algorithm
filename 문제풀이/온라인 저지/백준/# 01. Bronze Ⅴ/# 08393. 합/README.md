# 문제
- 플랫폼 : 백준
- 번호 : 08393
- 제목 : 합
- 난이도 : Bronze 5
- 1부터 n까지 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/8393" target="_blank">링크</a>

---

# 필요 알고리즘
- 등차수열의 합

---

# 풀이
```python
n = int(input())
answer = n * (n+1) >> 1
print(answer, end='')
```
- 등차수열의 합 활용
- `>>` : 정수 2 나누기와 구조적 동일

---
