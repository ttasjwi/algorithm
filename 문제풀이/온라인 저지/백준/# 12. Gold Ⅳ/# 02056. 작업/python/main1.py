import sys

src = sys.stdin.buffer

n = int(src.readline())
lines = [[*map(int, line.split())] for line in src.read().splitlines()]

nexts = [[] for _ in range(n + 1)]
in_degrees = [0] * (n + 1)
times = [0] * (n + 1)
total_times = [0] * (n + 1)
q = []

for i in range(n):
    times[i + 1] = lines[i][0]
    in_degrees[i + 1] = lines[i][1]
    if not lines[i][1]:
        total_times[i + 1] = times[i + 1]
        q.append(i + 1)
    for pre in lines[i][2:]:
        nexts[pre].append(i + 1)

while q:
    work = q.pop(0)
    for next in nexts[work]:
        in_degrees[next] -= 1
        total_times[next] = max(total_times[next], total_times[work] + times[next])
        if in_degrees[next] == 0:
            q.append(next)

print(max(total_times))
