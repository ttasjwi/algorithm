# 문제
- 플랫폼 : 백준
- 번호 : 01085
- 제목 : 직사각형에서 탈출
- 난이도 : Bronze 3
- 직사각형의 경계선까지 가는 거리의 최솟값 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1085" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
x, y, w, h = map(int, input().split())
answer = min(x, y, w - x, h - y)
print(answer, end='')
```
- 각 변들까지의 수선의 길이를 구하고, 이들 중 최솟값을 반환하면 된다.

---
