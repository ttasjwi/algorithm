birth_year, birth_month, birth_date = map(int, input().split())
current_year, current_month, current_date = map(int, input().split())

year_age = current_year - birth_year  # 연 나이
count_age = year_age + 1  # 세는 나이

if current_month > birth_month or (current_month == birth_month and current_date >= birth_date):
    full_age = year_age
else:
    full_age = year_age - 1

answer = '\n'.join([str(full_age), str(count_age), str(year_age)])
print(answer, end='')
