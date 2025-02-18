# 문제
- 플랫폼 : 프로그래머스
- 번호 : 049994
- 제목 : 방문 길이
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/49994" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
def solution(dirs):
    d = {'R': (1, 0, 0), 'D': (0, -1, 1), 'L': (-1, 0, 2), 'U': (0, 1, 3)} # x 방향값, y 방향값, 방향을 가리키는 정수 식별자
    answer = 0
    x, y = 0, 0
    s = set()
    for dir in dirs:
        nx, ny, d_id = x + d[dir][0], y + d[dir][1], d[dir][2] # 다음 x, 다음 y, 방향 정수 식별자
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            # 해당 경로로 한번도 안 지나왔다면
            if (x, y, d_id) not in s:
                answer += 1
                s.add((x, y, d_id))
                s.add((nx, ny, (d_id + 2) % 4)) # 반대방향에서 온 경우도 추가, (d_id + 2)%4 를 하면 반대 방향
            x, y = nx, ny
    return answer
```
