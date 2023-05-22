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
