# BOJ 02164 : 카드2

- 난이도 : Silver 4
- 숫자 하나 뽑고, 맨 앞 숫자 맨 뒤 이동 반복하여 마지막 남은 숫자 구하기 
- 문제 : [링크](https://www.acmicpc.net/problem/2164)

---

## 풀이
```python
import collections

n = int(input())
q = collections.deque([i for i in range(1, n + 1)])

while len(q) >= 2:
    q.popleft()
    q.append(q.popleft())

print(q.popleft(), end='')

```
- 파이썬에서 큐는 collections.deque를 쓴다.
- 맨 앞에 삽입 : appendleft(자바에서는 offer를 쓴다)
- 맨 뒤에 삽입 : append
- 맨 앞 추출 : popleft 
- 맨 뒤 추출 : pop
- 맨 앞 요소 확인 : `q[0]`
- 맨 뒤 요소 확인 : `q[-1]`

---
