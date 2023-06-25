# 문제
- 플랫폼 : 백준
- 번호 : 02506
- 제목 : 점수계산
- 난이도 : Bronze 3
- 시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2506" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())
scores = map(int, input().split())

total = 0
bonus = 0
for score in scores:
    if score == 1:
        bonus += 1
        total += bonus
    else:
        bonus = 0
print(total)
```
- 맞으면 bonus를 1 증가시키고, 현재 총점에 bonus를 더한다.
- 틀리면 bonus를 0으로 초기화한다.

---
