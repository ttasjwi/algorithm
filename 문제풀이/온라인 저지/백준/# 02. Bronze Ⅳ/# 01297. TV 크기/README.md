# 문제
- 플랫폼 : 백준
- 번호 : 01297
- 제목 : TV 크기
- 난이도 : Bronze 4
- 대각선 길이 D, TV의 높이 비율 H, TV의 너비 비율 W이 공백 한 칸을 사이에 두고 주어질 때, TV의 실제 높이, 너비의 길이 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1297" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
d, h_ratio, w_ratio = map(int, input().split())
x = d / (((h_ratio ** 2) + (w_ratio ** 2)) ** 0.5)

answer = ' '.join([str(int(h_ratio * x)), str(int(w_ratio * x))])
print(answer, end='')
```
- x : 실제 거리 d를 h_ratio, w_ratio에 대한 비로 나눈 값
- 이 값을 h_ratio에 곱하면 실제 높이값, w_ratio에 곱하면 실제 너비값을 구할 수 있다.

---
