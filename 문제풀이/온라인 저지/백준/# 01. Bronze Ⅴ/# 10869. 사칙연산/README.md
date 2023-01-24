# 문제
- 플랫폼 : 백준
- 번호 : 10869
- 제목 : 사칙연산
- 난이도 : Bronze 5
- 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10869" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
a, b = map(int, input().split())
answer = '\n'.join([
    str(a + b),
    str(a - b),
    str(a * b),
    str(a // b),
    str(a % b)
])
print(answer, end='')

```

---
