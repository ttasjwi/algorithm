# 문제
- 플랫폼 : 프로그래머스
- 번호 : 086491
- 제목 : 최소직사각형
- 난이도 : Level 1
- 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86491" target="_blank">링크</a>

---

# 필요 지식
- 최대, 최소 갱신 알고리즘

---

# 풀이
```python
from typing import List


def solution(sizes: List[int]):

    max_width, max_height = -1, -1
    for size in sizes:
        width, height = (size[0], size[1]) if size[0] >= size[1] else (size[1], size[0])

        if width > max_width:
            max_width = width
        if height > max_height:
            max_height = height

    return max_width * max_height
```
- 문제 상황에서는 가로-세로의 대소관계가 매번 다른데 한 쪽으로 통일해주면 문제상황이 간단해진다.
- 명함의 가로, 세로 중 긴 것을 가로 길이로 삼고, 작은 쪽을 세로 길이로 삼는다.
- 이들 중 가장 큰 가로값, 세로값을 지갑의 가로, 세로 길이로 삼는다.
- 이렇게 구해진 가로, 세로의 곱을 반환하면 된다.

## 참고
```python
def solution(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)
```
- 이렇게 한 줄로 풀 수도 있긴한데, 배열 순회를 여러번 돌기 때문에 효율적이지 못 하다.

---
