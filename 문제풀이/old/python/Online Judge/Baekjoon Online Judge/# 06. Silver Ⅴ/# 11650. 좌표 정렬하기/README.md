# BOJ 11650 : 좌표 정렬하기

- 난이도 : Silver 5
- 파이썬에서 우선순위를 두고 정렬하는 방법  
- 문제 : [링크](https://www.acmicpc.net/problem/11650)

---

## 풀이
```python
import sys

points = sys.stdin.readlines()[1:]
points.sort(key=lambda line: (int(line.split()[0]), int(line.split()[1])))

print(''.join(points), end='')

```
- key에서 인자는 각 요소임
- 인자의 어떤 것을 정렬기준으로 할지 튜플의 형태로 전달할 수 있다.
  - 앞의 것이 우선순위가 높다

---
