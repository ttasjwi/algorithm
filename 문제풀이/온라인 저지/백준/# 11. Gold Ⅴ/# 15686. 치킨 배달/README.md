# 문제
- 플랫폼 : 백준
- 번호 : 15686
- 제목 : 치킨 배달
- 난이도 : Gold 5
- 문제 : <a href="https://www.acmicpc.net/problem/15686" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
import sys
from itertools import combinations

print = sys.stdout.write
input = sys.stdin.readline

n, m = map(int, input().split())
city = []
for _ in range(n):
    city.append(list(map(int, input().split())))

# 치킨집, 가정집 위치
chickens = []
homes = []
for r in range(n):
    for c in range(n):
        if city[r][c] == 2:
            chickens.append((r, c))
        elif city[r][c] == 1:
            homes.append((r, c))

answer = sys.maxsize
for chicken_comb in combinations(chickens, m):
    # 각 가정집별 치킨 거리
    distances = [sys.maxsize] * len(homes)
    
    for ch_r, ch_c in chicken_comb:
        for i, (h_r, h_c) in enumerate(homes):
            distances[i] = min(distances[i], abs(ch_r - h_r) + abs(ch_c - h_c))
    answer = min(answer, sum(distances))
print(str(answer))
```
