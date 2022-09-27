def main():
    hour, minute = map(int, input().split())
    alarm_hour, alarm_minute = solution(hour, minute)
    print(alarm_hour, alarm_minute, sep=' ', end ='')


def solution(hour, minute):
    if minute >= 45:
        return hour, minute - 45
    else:
        if hour == 0:
            return 23, minute + 15
        return hour - 1, minute + 15


main()
