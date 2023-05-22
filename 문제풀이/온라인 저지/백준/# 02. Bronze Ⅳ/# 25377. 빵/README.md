# 문제
- 플랫폼 : 백준
- 번호 : 25377
- 제목 : 빵
- 난이도 : Bronze 4
- KOI 빵을 살 수 없다면, -1을 출력, KOI 빵을 살 수 있다면, 현재 시점에서 빵을 구하는 데 걸리는 최소 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25377" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def get_time(a, b):
    # 빵이 더 빨리 나올 때
    if a > b:
        return -1
    # 내가 도착함과 동시에 빵이 나올 떄
    elif a == b:
        return a
    # 내가 가고보니 좀 더 기다려야할 때
    else:
        return b


min_time = 1001
for _ in range(int(input())):
    a, b = map(int, input().split())
    time = 1001 if a > b else a if a == b else b
    min_time = min(min_time, time)
print(-1 if min_time == 1001 else min_time)
```
- get_time : 각 지점마다 내가 빵을 구할 수 있는 시간을 계산한다.
- 반복을 돌면서 각 지점마다 빵을 구할 수 있는 최소 시간을 구한다.
  - 1001 초는 최대시간보다 더 많은 시간이다. 빵을 구할 수 없음을 의미한다.
  - 최소시간이 1001초라는 것은 갱신이 되지 않았다는 것. 즉 빵을 구할 수 없음을 의미한다.
---

