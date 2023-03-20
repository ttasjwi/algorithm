# 문제
- 플랫폼 : 백준
- 번호 : 01158
- 제목 : 요세푸스 문제
- 난이도 : Silver 4
- N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1158" target="_blank">링크</a>

---

# 필요 알고리즘
- 큐
- 나머지 연산 활용

---

# 풀이

## 풀이1 : 큐
```python
import sys
from collections import deque

print = sys.stdout.write
n, k = map(int, input().split())

q = deque()
for i in range(1, n+1):
    q.append(i)
answer = []
print('<')
while q:
    for _ in range(k-1):
        q.append(q.popleft())
    answer.append(str(q.popleft()))
print(', '.join(answer))
print('>')
```
- `deque` 를 사용하여 큐를 구현했다.

## 풀이2 : 나머지 연산 활용
```python
import sys

print = sys.stdout.write
n, k = map(int, input().split())
items = [i for i in range(1, n + 1)]
answer = []

cursor = 0
print('<')
for _ in range(n):
    cursor += k - 1
    cursor = cursor % len(items)
    answer.append(str(items.pop(cursor)))
print(', '.join(answer))
print('>')
```
- 커서를 처음 위치에서 k-1번 이동한 위치에 있는 요소를 삭제하기를 반복한다.
- 이떄 요소의 위치가 배열의 길이를 벗어나게 되는 경우를 고려하여 배열의 길이 만큼 나눈 나머지로 커서의 위치를 결정한다.

---
