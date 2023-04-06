# 문제
- 플랫폼 : 백준
- 번호 : 11948
- 제목 : 과목선택
- 난이도 : Bronze 4
- 시험 점수의 합이 가장 높게 나오도록 과목을 선택할 때, JOI가 선택한 과목의 시험 점수의 합을 구하시오.
- 문제 : <a href="https://www.acmicpc.net/problem/11948" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
science = sum(sorted([int(input()) for _ in range(4)], reverse=True)[0:3])
society = max(int(input()) for _ in range(2))
print(science + society)
```
- 과학 : 4과목 중 가장 큰 두 과목
- 사회 : 2과목 중 가장 큰 과목
