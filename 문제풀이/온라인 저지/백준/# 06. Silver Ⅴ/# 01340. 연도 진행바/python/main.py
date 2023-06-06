month_map = {
    "January": 1,
    "February": 2,
    "March": 3,
    "April": 4,
    "May": 5,
    "June": 6,
    "July": 7,
    "August": 8,
    "September": 9,
    "October": 10,
    "November": 11,
    "December": 12
}
normal_days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
reap_days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]


def parse_time(line: str):
    month_name, day, year, time = line.split()

    month = month_map[month_name]
    day = int(day[:-1])
    year = int(year)
    hour, minute = map(int, time.split(sep=":"))
    return year, month, day, hour, minute


def calculate_total_year_minute(year):
    total_day = sum(reap_days) if is_reap_year(year) else sum(normal_days)
    return total_day * 24 * 60


def is_reap_year(year):
    return (year % 400 == 0) or (year % 4 == 0 and year % 100)


def calculate_minute_sum(year, month, day, hour, minute):
    minute += hour * 60
    minute += (day - 1) * 24 * 60
    minute += sum(reap_days[0:month]) * 24 * 60 if is_reap_year(year) else sum(normal_days[0:month]) * 24 * 60
    return minute


year, month, day, hour, minute = parse_time(input())
total_year_minute = calculate_total_year_minute(year)
minute_sum = calculate_minute_sum(year, month, day, hour, minute)
print(minute_sum / total_year_minute * 100)
