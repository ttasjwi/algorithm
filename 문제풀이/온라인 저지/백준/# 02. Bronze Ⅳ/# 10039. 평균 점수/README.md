# 문제
- 플랫폼 : 백준
- 번호 : 10039
- 제목 : 평균 점수
- 난이도 : Bronze 4
- 학생 5명의 평균 점수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10039" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print(sum(40 if x < 40 else x for x in list(map(int, sys.stdin.buffer.read().splitlines()))) // 5)
```
- 40보다 작으면 40으로 바꾸고, 합산한 결과를 5로 나눔

---
