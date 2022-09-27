# BOJ 16199 : 나이 계산하기

- 난이도 : Bronze 4
- 나이 계산
- 문제 : [링크](https://www.acmicpc.net/problem/16199)

---  

## 풀이

```python
birth_year, birth_month, birth_date = map(int, input().split())
current_year, current_month, current_date = map(int, input().split())

year_age = current_year - birth_year  # 만 나이
count_age = year_age + 1  # 세는 나이

full_age = None  # 만 나이
if current_month > birth_month or (current_month == birth_month and current_date >= birth_date):
    full_age = year_age
else:
    full_age = year_age - 1
print(full_age, count_age, year_age, sep='\n', end='')


```
- 연나이는 순전히 현재 연도 - 태어난 연도
- 세는 나이는 연나이 +1
- 만 나이는 생일 이전이면 연 나이 -1, 생일 이후면 연 나이와 같다

---
