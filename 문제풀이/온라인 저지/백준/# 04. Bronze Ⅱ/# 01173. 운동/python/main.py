N, m, M, T, R = map(int, input().split())


# N: 운동 목표 시간
# m: 최소 맥박
# M: 최대 맥박
# T: 운동 시 맥박 증가량
# R: 휴식 시 맥박 감소량

def solution():
    x = m  # 현재 맥박
    total_time = 0  # 경과 시간
    ex_time = 0  # 실제 운동한 시간

    # 최소 맥박 상태에서 운동을 했을 때 최대 맥박을 초과한다면, 휴식도 하지 못 하고 운동할 수 없는 상황이다.
    if m + T > M:
        return -1

    # 그 외의 경우에는 운동/휴식을 반복할 수 있는 경우이므로 운동과, 휴식을 반복한다.
    while ex_time < N:
        if x + T <= M:
            x += T
            ex_time += 1
        else:
            x = max(x - R, m)
        total_time += 1
    return total_time


print(solution())
