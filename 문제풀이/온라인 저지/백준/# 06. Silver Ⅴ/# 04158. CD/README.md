# 문제
- 플랫폼 : 백준
- 번호 : 04158
- 제목 : CD
- 난이도 : Silver 5
- 상근이와 선영이가 동시에 가지고 있는 CD의 갯수를 순서대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4158" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 투포인터

---

# 풀이

## 주의사항
- '입력은 여러 개의 테스트 케이스로 이루어져 있다.' 라는 문구에 주의해야한다. 이 문제의 테스트 케이스는 1개가 아니라
여러 건이다. 그래서 마지막 줄을 0 0으로 입력받는다고 되어 있는 것이다. 이것 때문에 여러번 틀렸다.

## 풀이1 : 해시 사용
```python
import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

current = 0
answer = []
while True:
    n, m = map(int, input().decode().split())

    if n == 0 and m == 0:
        break

    a = set(int(input()) for _ in range(n))
    b = set(int(input()) for _ in range(m))
    answer.append(str(len(a & b)))

answer = '\n'.join(answer)
print(answer)
```
- set에다 각 숫자들을 저장해두고 교집합 연산의 크기를 순서대로 append
- 메모리 비용이 비싸지만 빠르다

## 풀이2 : 투 포인터
```python
import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

current = 0
answer = []
while True:
    n, m = map(int, input().decode().split())

    if n == 0 and m == 0:
        break

    a = [int(input()) for _ in range(n)]
    b = [int(input()) for _ in range(m)]

    p1, p2 = 0, 0
    count = 0
    while p1 < n and p2 < m:
        if a[p1] == b[p2]:
            count += 1
            p1 += 1
            p2 += 1
        elif a[p1] < b[p2]:
            p1 += 1
        else:
            p2 += 1
    answer.append(str(count))

answer = '\n'.join(answer)
print(answer)
```
- 투 포인터를 통해, 포인터를 전진시켜가면서 비교했다.
- 해시 방식보다 느리다.

---
