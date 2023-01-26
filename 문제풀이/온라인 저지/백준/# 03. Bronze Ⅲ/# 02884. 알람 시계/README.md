# 문제
- 플랫폼 : 백준
- 번호 : 02884
- 제목 : 알람 시계
- 난이도 : Bronze 3
- 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸기
- 문제 : <a href="https://www.acmicpc.net/problem/2884" target="_blank">링크</a>

---

# 필요 알고리즘
- 시간 계산

---

# 풀이
```python
h, m = map(int, input().split())

m -= 45

if m < 0:
    m += 60
    h -= 1
    if h < 0:
        h += 24

answer = ' '.join([str(h), str(m)])
print(answer, end='')
```
- 분을 45 차감
- 분이 0보다 작으면 시간을 1 차감하고 분을 60 증가
- 시간이 0보다 작으면 시간에 24를 증가

---
