# 문제
- 플랫폼 : 백준
- 번호 : 32626
- 제목 : SCP에 가는 길
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/32626" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python

sx, sy = map(int, input().split())
ex, ey = map(int, input().split())
px, py = map(int, input().split())

if sx == ex:
    if sx == px and (sy < py < ey or ey < py < sy):
        answer = 2
    else:
        answer = 0
elif sy == ey:
    if sy == py and (sx < px < ex or ex < px < sx):
        answer = 2
    else:
        answer = 0
else:
    answer = 1
print(answer, end= '')
```
- 시작점과 끝점의 x 또는 y 좌표가 같은 경우
  - 둘 사이에 p 가 있을 경우 : 방향을 두 번 바꿔야 한다. (2)
  - 둘 사이에 p 가 없을 경우 : 그냥 바로 한 방향으로 가면 된다. (0)
- 그 외의 경우 : 한 번만 방향을 바꾸면 된다.

---
