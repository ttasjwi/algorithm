def solution(n):
    answer = [0] * (n * (n + 1) // 2)
    directions = [(1, 0), (0, 1), (-1, -1)]
    r = -1
    c = 0
    max_number = n * (n + 1) // 2
    number = 1

    while number <= max_number:
        for (dr, dc) in directions:
            while number <= max_number:
                nr, nc = r + dr, c + dc
                n_idx = get_idx(nr, nc)
                if (0 <= nr < n) and (0 <= nc <= nr) and answer[n_idx] == 0:
                    answer[n_idx] = number
                    number += 1
                    r, c = nr, nc
                else:
                    break
    return answer

def get_idx(r, c):
    return r * (r + 1) // 2 + c
