# 문제
- 플랫폼 : 백준
- 번호 : 11866
- 제목 : 요세푸스 문제 0
- 난이도 : Silver 5
- 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라 할 때, N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11866" target="_blank">링크</a>

---

# 필요 알고리즘
- 큐

---

# 풀이

## 풀이1
```python
n, k = map(int, input().split())
q = [i for i in range(1, n+1)]
result = []
idx = 0
while q:
    idx += k - 1
    if idx >= len(q):
        idx %= len(q)
    result.append(q.pop(idx))

print(str(result).replace('[', '<').replace(']', '>'))
```
- k-1번 인덱스를 이동하고(길이보다 길면 len으로 나눈 나머지로 삼는다.) 해당 위치의 요소를 제거한다.
- 큐가 빌 때까지 반복

---

## 풀이2
```python
import sys

print = sys.stdout.write

n, k = map(int, input().split())
q = [i for i in range(1, n+1)]
result = []
while q:
    for i in range(k-1):
        q.append(q.pop(0))
    result.append(q.pop(0))

print(str(result).replace('[', '<').replace(']', '>'))
```
- 정말 문제에서 시킨대로 순서대로 계속 뽑는다.

---
