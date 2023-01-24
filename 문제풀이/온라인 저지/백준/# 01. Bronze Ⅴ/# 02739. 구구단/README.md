# 문제
- 플랫폼 : 백준
- 번호 : 02739
- 제목 : 구구단
- 난이도 : Bronze 5
- N을 입력받은 뒤, 구구단 N단을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2739" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = '\n'.join(f'{n} * {i} = {n * i}' for i in range(1, 9+1))
print(answer)
```

---
