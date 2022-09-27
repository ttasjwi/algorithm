# BOJ 02753 : 윤년

- 난이도 : Bronze 5
- 윤년인지 판단하여 결과 출력
- 문제 : [링크](https://www.acmicpc.net/problem/2753)

---  

## 풀이
```python
def main():
    year = int(input())
    print(1 if is_leap_year(year) else 0, end='')


def is_leap_year(year):
    return ((year % 4) == 0 and (year % 100) != 0) or (year % 400) == 0


main()

```
- 연도를 입력받고 윤년인지 판단하여 결과 출력

---
