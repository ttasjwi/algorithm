# BOJ 02845 : 파티가 끝나고 난 뒤
- 난이도 : Bronze 4
- 단순 사칙연산, 비교
- 문제 : [링크](https://www.acmicpc.net/problem/2845)

---  

## 풀이
```python
l, p = map(int, input().split())
n = l * p  # 실제 사람 수
results = [int(x) - n for x in input().split()]  # 오차들
print(*results, sep=' ', end='')

```
- `1m^2` 당, l명이 있고, 전체 면적이 p이므로, 총 l*p명이 실제로 존재한다.
- 각 입력값마다 l*p를 차감한 값이 오차가 된다.
- 이들을 출력하면 된다.

---
