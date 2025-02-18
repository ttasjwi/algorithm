def solution(dirs):
    d = {'R': (1, 0, 0), 'D': (0, -1, 1), 'L': (-1, 0, 2), 'U': (0, 1, 3)}
    answer = 0
    x, y = 0, 0
    s = set()
    for dir in dirs:
        nx, ny, d_id = x + d[dir][0], y + d[dir][1], d[dir][2]
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            if (x, y, d_id) not in s:
                answer += 1
                s.add((x, y, d_id))
                s.add((nx, ny, (d_id + 2) % 4))
            x, y = nx, ny
    return answer
