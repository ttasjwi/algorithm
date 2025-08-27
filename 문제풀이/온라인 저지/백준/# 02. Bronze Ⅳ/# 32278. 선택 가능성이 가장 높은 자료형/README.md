# 문제
- 플랫폼 : 백준
- 번호 : 32278
- 제목 : 선택 가능성이 가장 높은 자료형
- 난이도 : Bronze 4
- 문제 : <a href="https://www.acmicpc.net/problem/32278" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())

if n > 2**31 -1 or n < - 2**31:
    answer = 'long long'
elif n > 2**15 -1 or n < -2 ** 15:
    answer = 'int'
else:
    answer = 'short'
print(answer, end ='')
```
- 간단한 분기처리

---
