# BOJ 02530 : 인공지능 시계
- 난이도 : Bronze 4
- 시간 덧셈
- 문제 : [링크](https://www.acmicpc.net/problem/2530)

---  

## 풀이
```python
h, m, s = map(int, input().split())
d = int(input())
total = h * 60 * 60 + m * 60 + s + d
h, m, s = (total // 3600) % 24, (total // 60) % 60, total % 60
print(h, m, s, sep=' ', end='')

```
- 시간들을 입력
- 합산한 초 계산
- 합산한 초를 나눠서 시간으로 변환

---
