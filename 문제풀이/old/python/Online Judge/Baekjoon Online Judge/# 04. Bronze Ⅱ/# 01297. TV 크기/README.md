# BOJ 01297 : TV 크기
- 난이도 : Bronze 2
- 비율을 기반으로 실제 길이 계산
- 문제 : [링크](https://www.acmicpc.net/problem/1297)

---  

## 풀이
```python
d, h, w = map(int, input().split())
r = d / (h**2 + w**2) ** 0.5
print(int(h*r), int(w*r), sep=' ', end='')

```
- 높이, 너비, 대각선의 길이 비는 `h : w : (h**2 + w**2) ** 0.5`
- 이들 값에 r배를 한 것을 실제 길이라 하자.
- d가 주어졌을 때 r값은 `d / (h**2 + w**2) ** 0.5`와 같다.
- 실제 높이, 너비는 `h*r`, `w*r`과 같다.

---
