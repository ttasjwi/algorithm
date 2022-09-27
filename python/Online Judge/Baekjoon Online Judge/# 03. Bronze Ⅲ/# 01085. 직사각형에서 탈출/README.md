# BOJ 01085 : 직사각형에서 탈출
- 난이도 : Bronze 3
- 직사각형 내부 점에서 수선의 길이 최솟값
- 문제 : [링크](https://www.acmicpc.net/problem/1085)

---  

## 풀이
```python
x, y, w, h = map(int, input().split())
answer = min(x, y, w - x, h - y)
print(answer, end='')

```
- 수선의 길이들은 x, y, w-x, h-y 이므로 이들의 최솟값을 반환하면 된다.

---
