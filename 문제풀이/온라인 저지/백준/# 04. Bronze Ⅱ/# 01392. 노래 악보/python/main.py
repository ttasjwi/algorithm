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
