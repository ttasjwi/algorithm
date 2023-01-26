# 문제
- 플랫폼 : 백준
- 번호 : 01297
- 제목 : TV 크기
- 난이도 : Bronze 2
- 대각선 길이 D, TV의 높이 비율 H, TV의 너비 비율 W이 공백 한 칸을 사이에 두고 주어질 때, TV의 실제 높이, 너비의 길이 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1297" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
d, h, w = map(int, input().split())
r = d / (((h ** 2) + (w ** 2)) ** 0.5)

answer = ' '.join([str(int(h * r)), str(int(w * r))])
print(answer, end='')
```
- 높이, 너비, 대각선의 길이 비는 `h : w : (h**2 + w**2) ** 0.5`
- 이들 값에 r배를 한 것을 실제 길이라 하자.
- d가 주어졌을 때 r값은 `d / (h**2 + w**2) ** 0.5`와 같다.
- 실제 높이, 너비는 `h*r`, `w*r`과 같다.

- x : 실제 거리 d를 h_ratio, w_ratio에 대한 비로 나눈 값
- 이 값을 h_ratio에 곱하면 실제 높이값, w_ratio에 곱하면 실제 너비값을 구할 수 있다.

---
