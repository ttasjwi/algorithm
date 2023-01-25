# 문제
- 플랫폼 : 백준
- 번호 : 10872
- 제목 : 팩토리얼
- 난이도 : Bronze 5
- N!을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10872" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = 1
for i in range(2, n+1):
    answer *= i
print(answer, end='')
```

---
