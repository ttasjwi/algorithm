# 문제
- 플랫폼 : 백준
- 번호 : 02530
- 제목 : 인공지능 시계
- 난이도 : Bronze 4
- 현재 시각이 시, 분, 초 순으로 주어지고, 경과된 시간이 초단위로 주어질 때 경과 후 시각을 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/2530" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
h, m, s = map(int, input().split())
s += int(input())

if s >= 60:
    m += s // 60
    s = s % 60

if m >= 60:
    h += m // 60
    m = m % 60

if h >= 24:
    h = h % 24

answer = ' '.join([str(h), str(m), str(s)])
print(answer, end='')
```
- 초를 합산하고, 초가 60초 이상이면 초과된 분량을 분으로 이월한다.
- 분이 60초 이상이면 초과된 분량을 시로 이월한다.
- 시가 24 이상이면 24로 나눈 나머지로 대체한다.

---
