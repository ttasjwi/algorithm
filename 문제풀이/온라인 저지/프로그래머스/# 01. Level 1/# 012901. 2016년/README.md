# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012901
- 제목 : 2016년
- 난이도 : Level 1
- 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12901 target="_blank">링크</a>

---

# 필요 지식
- 날짜 계산법
- 요일 함수 사용
  - 실제 시험장에서 이런 문제를 푼다면 그냥 검색해서 요일함수를 쓸 것 같다.

---

# 풀이
## 풀이1: 요일 함수 사용
```python
from datetime import date


def solution(a, b):
    weekdays = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    return weekdays[date(2016, a, b).weekday()]
```
- 파이썬의 datetime 모듈에 위치한 date 함수를 사용하면 편리하게 날짜를 계산할 수 있다.
  - `date(...)` : 날짜 객체 반환
  - `weekday` : 요일을 0, 1, 2, 3, ... 으로 반환한다. (0이 월요일)


## 풀이2 : 월, 일 날짜 누적과 나머지 활용
```python
def solution(a, b):
    days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    weekdays = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED']

    day_sum = sum(days[:a]) + b
    return weekdays[day_sum % 7]
```
- days : 각 월별 일수를 저장한 배열
- weeksdays : 요일 문자열을 순서대로 저장한 배열
  - 1월 1일이 금요일이므로, 1번 인덱스에 금요일을 두어 계산을 편하게 했다.
- day_sum : `sum(days[:a])` + b
  - 날짜의 합을 구한다. a월 이전의 날짜를 모두 합하고, 그 후 해당 월의 경과 일자를 합산한다.
- 반환값
  - day_sum을 7로 나눈 나머지를 구해서, weekdays의 해당 인덱스에 있는 문자열을 반환한다.

---
