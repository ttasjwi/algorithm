# 문제
- 플랫폼 : 백준
- 번호 : 10991
- 제목 : 별 찍기 - 16
- 난이도 : Bronze 3
- 예제를 보고 규칙을 유추한 뒤에 별을 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/10991" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = '\n'.join(' '* (n-i) + '* '*i for i in range(1, n+1))
print(answer, end ='')
```

---
