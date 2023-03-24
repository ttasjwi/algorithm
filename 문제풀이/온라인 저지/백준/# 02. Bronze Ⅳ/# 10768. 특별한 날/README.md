# 문제
- 플랫폼 : 백준
- 번호 : 10768
- 제목 : 특별한 날
- 난이도 : Bronze 4
- 사용자로부터 정수인 월과 일을 입력받아 날짜가 2월 18일인지 전인지 후인지를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10768" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
month = int(input())
day = int(input())
print("After" if month > 2 or (month == 2 and day > 18) else "Special" if month == 2 and day == 18 else "Before")
```
- 2월 이후 또는 2월인데 18일 이후 : "After"
- 2월 18일 : "Special"
- 그 외 : "Before"

---
