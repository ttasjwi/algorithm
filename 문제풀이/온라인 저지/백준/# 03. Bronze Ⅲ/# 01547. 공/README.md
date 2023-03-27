# 문제
- 플랫폼 : 백준
- 번호 : 01547
- 제목 : 공
- 난이도 : Bronze 3
- 공이 사라져서 컵 밑에 없는 경우에는 -1을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1547" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

src = sys.stdin.buffer

src.readline()
cups = [0, 1, 0, 0]

for line in src.read().splitlines():
    x, y = map(int, line.split())
    cups[x], cups[y] = cups[y], cups[x]
print(cups.index(1))
```
- 리스트의 1번 인덱스에 1을 삽입한다. 나머지엔 0을 삽입한다.
- 튜플을 이용해 리스트 요소를 스왑하기를 반복한다.
- 최종적으로 1이 있는 인덱스를 반환하면 된다.
  - 공이 사라져서 컵 밑에 없는 경우에는 -1을 출력하라고 되어 있는데 이건 페이크다. 그럴 일이 없다.

---
