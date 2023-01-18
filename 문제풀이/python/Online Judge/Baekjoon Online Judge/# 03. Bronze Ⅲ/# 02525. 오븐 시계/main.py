def main():
    hour, minute = map(int, input().split())
    append_minute = int(input())
    end_hour, end_minute = solution(hour, minute, append_minute)
    print(end_hour, end_minute, sep=' ', end='')


def solution(hour, minute, append_minute):
    full_time = hour * 60 + minute + append_minute

    end_hour = full_time // 60 % 24
    end_minute = full_time % 60
    return end_hour, end_minute


main()
