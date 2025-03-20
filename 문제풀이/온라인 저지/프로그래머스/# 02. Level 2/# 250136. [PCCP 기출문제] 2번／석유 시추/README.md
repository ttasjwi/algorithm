# 문제
- 플랫폼 : 프로그래머스
- 번호 : 250136
- 제목 : \[PCCP 기출문제\] 2번／석유 시추
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250136" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```python
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

def solution(land):
    w = len(land[0])
    h = len(land)
    result = [0] * w

    def dfs(r, c):
        columns = {c} # 현재 석유 덩어리가 걸쳐진 열
        stack = [(r, c)]
        land[r][c] = 0
        count = 1

        while stack:
            cur_r, cur_c = stack.pop()
            for dr, dc in directions:
                nr, nc = cur_r + dr, cur_c + dc
                if 0 <= nr < h and 0 <= nc < w and land[nr][nc] == 1:
                    count += 1
                    land[nr][nc] = 0
                    columns.add(nc)
                    stack.append((nr, nc))

        # 덩어리가 걸쳐진 열들을 순회하면서, count 만큼 증가
        for col in columns:
            result[col] += count
        return

    for r in range(h):
        for c in range(w):
            if land[r][c] == 1:
                dfs(r, c)
    return max(result)
```
