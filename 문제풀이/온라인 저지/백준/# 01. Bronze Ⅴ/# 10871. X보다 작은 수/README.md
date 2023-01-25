# 문제
- 플랫폼 : 백준
- 번호 : 10871
- 제목 : X보다 작은 수
- 난이도 : Bronze 5
- X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10871" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n, x = map(int, input().split())
answer = ' '.join([i for i in input().split() if int(i) < x])
print(answer, end='')
```

---
