def main():
    year = int(input())
    print(1 if is_leap_year(year) else 0, end='')


def is_leap_year(year):
    return ((year % 4) == 0 and (year % 100) != 0) or (year % 400) == 0


main()
