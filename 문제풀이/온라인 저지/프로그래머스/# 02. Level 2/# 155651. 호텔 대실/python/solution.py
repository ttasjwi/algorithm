def solution(book_time):

    # 각 시각(분단위)별 필요한 방의 갯수
    room_counts = [0] * 1440
    max_room_count = -1 # 제일 많이 방이 필요한 시점의 방의 갯수

    for time_arr in book_time:
        start_min, end_min = get_start_and_end_minute(time_arr)
        for i in range(start_min, end_min + 1):
            room_counts[i] += 1 # 시작~종료까지, 그 시점의 필요한 방의 갯수 1 증가
            if max_room_count < room_counts[i]:
                max_room_count = room_counts[i]
    return max_room_count


# 시작, 종료시간을 분 숫자로 파싱
def get_start_and_end_minute(time_arr):
    start_min = get_minute(time_arr[0])
    end_min = get_minute(time_arr[1]) + 9 # 종료 시간은 실 종료시간으로부터 9분 뒤까지

    # 종료시간이 혹시 1440(자정)을 넘으면, 1439(23:59) 로 맞추기
    if end_min >= 1440:
        end_min = 1439
    return start_min, end_min

# 시간 문자열을 파싱
def get_minute(time_str):
    a, b = map(int, time_str.split(':'))
    return a * 60 + b
