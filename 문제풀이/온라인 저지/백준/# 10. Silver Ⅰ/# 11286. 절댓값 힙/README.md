# 문제
- 플랫폼 : 백준
- 번호 : 11286
- 제목 : 절댓값 힙
- 난이도 : Silver 1
- 절댓값이 제일 작은(만약 절댓값이 같으면 실제 값이 더 작은) 요소를 최솟값으로 취급하는 최소힙 구현
- 문제 : <a href="https://www.acmicpc.net/problem/11286" target="_blank">링크</a>

---

# 필요 알고리즘
- 힙
  - 파이썬은 heapq 모듈이 힙으로 구현되어 있다.
  - 파이썬의 heapq는 최소힙으로 구현되어 있다.
  - 부모가 항상 작고, 자식 노드의 순서는 정렬되어 있지 않다.
  - 삽입의 시간 복잡도 : O(log n)
  - 추출의 시간 복잡도 : O(log n)
  - 최솟값 확인 : O(1)

---

# 풀이
## 풀이1
```python
import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write
src.readline()
commands = list(map(int, src.read().splitlines()))

q = []
for command in commands:
    if command == 0:
        if not q:
            print('0\n')
        else:
            _, value = heapq.heappop(q)
            print(str(value) + '\n')
    else:
        heapq.heappush(q, (abs(command), command))
```
- 삽입연산 : 튜플 형태로 저장
  - 절댓값, 실젯값 순으로 저장
- 추출연산 : 최솟값을 바로 추출


## 풀이2 (속도는 더 빨리 나옴)
```python
import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write
src.readline()
commands = list(map(int, src.read().splitlines()))

plus_heap = []
minus_heap = []

for x in commands:
    if x > 0:
        heapq.heappush(plus_heap, x)
    elif x < 0:
        heapq.heappush(minus_heap, -x)
    else:
        if plus_heap and minus_heap:
            if plus_heap[0] >= minus_heap[0]:
                print(str(-heapq.heappop(minus_heap)) + '\n')
            else:
                print(str(heapq.heappop(plus_heap)) + '\n')
        elif plus_heap:
            print(str(heapq.heappop(plus_heap)) + '\n')
        elif minus_heap:
            print(str(- heapq.heappop(minus_heap)) + '\n')
        else:
            print('0\n')
```
- 양수를 저장하는 최소힙, 음수를 저장하는 최소힙을 준비
  - 음수를 저장하는 최소힙은 부호를 반대로 하여, 양수의 형태로 저장함
- 양수힙/음수힙 모두 요소가 있을 때
  - 두 힙에서 최솟값을 비교하여 더 작은 쪽을 출력
- 양수힙/음수힙 어느 한쪽에만 요소가 있을 때
  - 해당 힙에서 요소 추출
- 양수힙/음수힙 모두 요소가 없을 때
  - 0 출력

---
