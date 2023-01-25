# 문제
- 플랫폼 : 백준
- 번호 : 10101
- 제목 : 삼각형 외우기
- 난이도 : Bronze 4
- 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어질 때 삼각형의 종류 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10101" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
a, b, c = int(input()), int(input()), int(input())

if a + b + c != 180:
    answer = 'Error'
elif a == b == c:  # 정삼각형
    answer = 'Equilateral'
elif a == b or b == c or c == a:  # 이등변 삼각형
    answer = 'Isosceles'
else:
    answer = 'Scalene'

print(answer, end='')
```

---
