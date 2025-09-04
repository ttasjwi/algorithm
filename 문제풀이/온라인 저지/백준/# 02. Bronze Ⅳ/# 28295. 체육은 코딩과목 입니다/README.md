# 문제
- 플랫폼 : 백준
- 번호 : 28295
- 제목 : 체육은 코딩과목 입니다
- 난이도 : Bronze 4
- 문제 : <a href="https://www.acmicpc.net/problem/28295" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
d = 0
symbol = ['N', 'E', 'S', 'W']

for _ in range(10):
    cmd = input()
    # 우향우
    if cmd == '1':
        d = (d + 1) % 4
    # 뒤로 돌아
    elif cmd == '2':
        d = (d + 2) % 4
    # 좌향좌
    else:
        d = (d - 1) % 4
print(symbol[d], end = '')
```
- 방향을 0부터 3까지 북,동,남,서 로 정한다. 
- 이렇게 하면 +1 하는 방향은 시계방향, -1 하는 방향은 반시계 방향이 된다.
- 각 동작마다 (%4) 연산이 있는데, 이는 한바퀴 돌았을 때 처음 방향 그대로 되돌아가는 성격을 이용한 것이다.

