from datetime import date


def solution(a, b):
    weekdays = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    return weekdays[date(2016, a, b).weekday()]
