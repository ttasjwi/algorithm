# 문제
- 플랫폼 : 백준
- 번호 : 10430
- 제목 : 나머지
- 난이도 : Bronze 5
- 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10430" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
a, b, c = map(int, input().split())

answer = '\n'.join([
    str((a + b) % c),
    str(((a % c) + (b % c)) % c),
    str((a * b) % c),
    str(((a % c) * (b % c)) % c)
])

print(answer, end='')
```

---
