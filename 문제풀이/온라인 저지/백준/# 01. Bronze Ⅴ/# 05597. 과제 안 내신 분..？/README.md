# 문제
- 플랫폼 : 백준
- 번호 : 05597
- 제목 : 과제 안 내신 분..?
- 난이도 : Bronze 5
- 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/5597" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os

input_all = io.BytesIO(os.read(0, os.fstat(0).st_size)).read

students = {str(i) for i in range(1, 30 + 1)} - set(input_all().decode().split())
answer = '\n'.join(sorted(students, key=lambda x: int(x)))
print(answer, end='')
```

---
