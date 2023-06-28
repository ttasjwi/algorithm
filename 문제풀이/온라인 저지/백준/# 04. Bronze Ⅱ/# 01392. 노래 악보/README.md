# 문제
- 플랫폼 : 백준
- 번호 : 01392
- 제목 : 노래 악보
- 난이도 : Bronze 2
- Q개에 줄에 1번 질문부터 Q번 질문까지 해당 시간(초)에 부르는 악보의 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1392" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n, q = map(int, input().split())
times = [0] + [int(input()) for _ in range(n)]
play_times = [0] * 10000  # i초에 부르는 노래

time_sum = 0

for i in range(1, n + 1):
    time = times[i]
    play_times[time_sum:time_sum + time] = [i] * time
    time_sum += time

print('\n'.join([str(play_times[int(input())]) for _ in range(q)]))
```
- times 배열에 i번 악보의 시간을 저장한다
- play_times 배열에, i초에 부르는 노래의 악보 번호를 저장한다.
- 이후 question이 들어올 때마다, play_times 배열에서 결과를 꺼내 출력한다.

---
