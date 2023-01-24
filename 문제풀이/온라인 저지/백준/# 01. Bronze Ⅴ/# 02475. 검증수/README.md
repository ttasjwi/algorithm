# 문제
- 플랫폼 : 백준
- 번호 : 02475
- 제목 : 검증수
- 난이도 : Bronze 5
- 각 숫자를 제곱한 수들의 합을 10으로 나눈 나머지를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2475" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
answer = sum(int(i) ** 2 for i in input().split()) % 10
print(answer, end='')
```

---
