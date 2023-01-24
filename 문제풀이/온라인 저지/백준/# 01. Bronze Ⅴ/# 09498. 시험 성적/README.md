# 문제
- 플랫폼 : 백준
- 번호 : 09498
- 제목 : 시험 성적
- 난이도 : Bronze 5
- 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9498" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
score = int(input())

if score >= 90:
    answer = 'A'
elif score >= 80:
    answer = 'B'
elif score >= 70:
    answer = 'C'
elif score >= 60:
    answer = 'D'
else:
    answer = 'F'

print(answer, end='')
```
- 단순 조건문 사용

---
