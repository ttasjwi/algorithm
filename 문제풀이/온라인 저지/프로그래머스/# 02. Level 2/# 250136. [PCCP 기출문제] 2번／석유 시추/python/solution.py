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
