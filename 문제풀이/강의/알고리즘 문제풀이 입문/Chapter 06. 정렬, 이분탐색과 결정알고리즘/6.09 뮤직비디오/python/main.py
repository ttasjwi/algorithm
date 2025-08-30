n, m = map(int, input().split())

lt = -1
rt = 0
music_times = list(map(int, input().split()))

for music_time in music_times:
    if lt < music_time:
        lt = music_time
    rt += music_time

answer = rt
while lt <= rt:
    # 한 DVD의 용량
    mid = (lt + rt) >> 1

    # (최소 조건) m 개 DVD 안에 모두 넣을 수 있어야함

    time_sum = 0
    count = 0
    for i, music_time in enumerate(music_times):
        time_sum += music_time
        if i == len(music_times) - 1 or time_sum + music_times[i+1] > mid:
            count += 1
            time_sum = 0

    # 더 DVD 용량을 늘려서, 갯수를 줄여야 함.
    if count > m:
        lt = mid + 1

    # DVD 용량이 조건에 부합할 경우, 혹시 더 줄일 수 있는지 확인하여 줄여나가기
    else:
        rt = mid - 1
        answer = mid

print(answer, end ='')
