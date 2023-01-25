# 문제
- 플랫폼 : 백준
- 번호 : 02525
- 제목 : 오븐 시계
- 난이도 : Bronze 3
- 현재 시각, 조리 소요 시간이 주어질 떄 조리 완료 시각을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2525" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
h, m = map(int, input().split())
m += int(input())

if m >= 60:
    h += m // 60
    m = m % 60
if h >= 24:
    h = h % 24
answer = ' '.join([str(h), str(m)])
print(answer, end='')
```

---
