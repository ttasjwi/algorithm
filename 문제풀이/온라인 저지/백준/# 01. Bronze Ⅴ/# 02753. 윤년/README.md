# 문제
- 플랫폼 : 백준
- 번호 : 02753
- 제목 : 윤년
- 난이도 : Bronze 5
- 첫째 줄에 윤년이면 1, 아니면 0을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2753" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
year = int(input())
answer = 1 if ((year % 4 == 0) and (year % 100 != 0)) or (year % 400 == 0) else 0
print(answer, end='')
```
- 4의 배수이면서 100의 배수가 아니고, 또는 400의 배수인 경우 윤년(1)
- 조건 그대로 코드에 반영하면 됨

---
