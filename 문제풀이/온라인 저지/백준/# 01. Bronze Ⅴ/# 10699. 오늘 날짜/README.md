# 문제
- 플랫폼 : 백준
- 번호 : 10699
- 제목 : 오늘 날짜
- 난이도 : Bronze 5
- 채점 서버 시간대가 UTC+0이고, 서울은 UTC+9일 때, 서울의 오늘 날짜를 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/10699" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
print('2023-01-24', end='')
```
- 채점 서버의 시간대는 utc+0이고, 서울은 utc+9이다.
- 채점 서버의 시간대는 한국 시간에서 9시간을 뺀 값이다.
- 내가 푼 시점은 2023년 1월 24일 20시이므로, 채점 시간대는 2023년 1월 24일 11시이다.
- 따라서 2023년 1월 24일을 출력하면 되는 것이다.

---
