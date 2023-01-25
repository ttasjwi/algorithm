# 문제
- 플랫폼 : 백준
- 번호 : 15727
- 제목 : 조별과제를 하려는데 조장이 사라졌다
- 난이도 : Bronze 5
- 성우가 최소 t분만에 민건이를 찾을 수 있을 때, t 이상의 가장 작은 정수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15727" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
l = int(input())
answer = (l // 5) if l % 5 == 0 else (l // 5 + 1)
print(answer, end='')
```

---
