# 문제
- 플랫폼 : 백준
- 번호 : 01929
- 제목 : 소수 구하기
- 난이도 : Silver 3
- m 이상 n 이하 소수를 모두 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1929" target="_blank">링크</a>

---

# 필요 알고리즘
- 에라토스테네스의 체

---

# 풀이
```python
m,n = map(int, input().split())

check = [False, True] + [False] * (n-1)

for i in range(2, n+1):
    if not check[i]:
        for j in range(2*i, n+1, i):
            check[j] = True

answer = '\n'.join(str(i) for i in range(m, n+1) if not check[i])
print(answer, end='')
```

---
