# 문제
- 플랫폼 : 백준
- 번호 : 25625
- 제목 : 샤틀버스
- 난이도 : Bronze 4
- 민준이가 버스에 탑승하기 위해서 기다려야 하는 최소 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25625" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
x, y = map(int, input().split())
print(y - x if y > x else x + y)
```
- y가 x보다 크다는 것은 버스의 방향이 서울대 입구역을 향하고 있다는 것을 의미한다.
  - y에서 x값을 뺀 값 만큼이, 서울대 입구역을 향하는 버스의 실질 이동거리에 해당한다.
- 그 외의 경우에는 버스가 제2공학관으로 가고 있다는 것을 의미하므로, 2공학관으로 가는 시간에 해당하는 시간(y)에 서울대입구역을 향하는 시간(x)
를 더해줘야한다.

---
