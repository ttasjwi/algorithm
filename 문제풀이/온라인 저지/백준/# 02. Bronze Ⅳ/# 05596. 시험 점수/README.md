# 문제
- 플랫폼 : 백준
- 번호 : 05596
- 제목 : 시험 점수
- 난이도 : Bronze 4
- 문제에서 요구하는 정답을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5596" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
print(max(sum(map(int, input().split())), sum(map(int, input().split()))))
```
- 각 라인의 합의 최댓값 출력

---
