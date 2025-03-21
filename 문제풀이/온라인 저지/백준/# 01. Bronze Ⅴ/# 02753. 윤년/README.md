# 문제
- 플랫폼 : 백준
- 번호 : 02753
- 제목 : 윤년
- 난이도 : Bronze 5
- 문제 : <a href="https://www.acmicpc.net/problem/2753" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
year = int(input())
print('1' if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0 else '0')
```
