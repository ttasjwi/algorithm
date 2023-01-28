# 문제
- 플랫폼 : 백준
- 번호 : 01002
- 제목 : 터렛
- 난이도 : Silver 3
- 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과
백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1002" target="_blank">링크</a>

---

# 필요 알고리즘
- 기하

---

# 풀이
```python
import io, os, sys
from math import sqrt

print = sys.stdout.write
lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]


def main():
    answer = '\n'.join(str(calculate(line)) for line in lines)
    print(answer)


def calculate(line: str):
    x1, y1, r1, x2, y2, r2 = map(int, line.split())
    d = sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

    # 같은 원
    if d == 0 and r1 == r2:
        return -1

    # 외접, 내접
    if r1 + r2 == d or abs(r1 - r2) == d:
        return 1

    # 두 점에서 만난다
    if abs(r1 - r2) < d < r1 + r2:
        return 2

    # 만나지 않는 두 원
    else:
        return 0


if __name__ == '__main__':
    main()
```
- 중심 거리를 d라 하자. 이제 여기서 케이스 분류를 할 수 있다.
  - d == 0이고, 반지름이 같다면 두 원은 같다. (무수히 많은 위치)
  - r1 + r2 == d 이면 두 원은 외접한다.(1개의 위치)
  - abs(r1 - r2) == d 이면, 두 원은 내접한다.(1개의 위치)
  - 중심 거리가 반지름 차보다 크고, 반지름 합보다 작으면 두 점에서 만난다. (2개의 위치)
  - 그 외의 경우에는 만나지 않는다. (0개의 위치)
- 수학적 지식을 필요로 하는 문제였다.

---
