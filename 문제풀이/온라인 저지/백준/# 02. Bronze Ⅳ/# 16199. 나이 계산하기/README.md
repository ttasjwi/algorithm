# 문제
- 플랫폼 : 백준
- 번호 : 16199
- 제목 : 나이 계산하기
- 난이도 : Bronze 4
- 첫째 줄에 만 나이, 둘째 줄에 세는 나이, 셋째 줄에 연 나이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/16199" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
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
```
- 연나이 : 현재 연도 - 출생 년도
- 세는 나이 : 연나이 + 1
- 만나이
  - 현재 월이 태어난 월, 날짜 이후 연 나이와 만 나이가 같다.
  - 그렇지 않으면 연나이 - 1과 같다

---
