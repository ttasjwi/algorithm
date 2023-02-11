# 문제
- 플랫폼 : 백준
- 번호 : 02110
- 제목 : 공유기 설치
- 난이도 : Gold 4
- '가장 인접한 두 공유기 사이의 거리'를 가능한 크게 하여 공유기를 설치하려고 할 때 가장 인접한 두 공유기 사이의 최대 거리를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2110" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색
- 매개변수 탐색

---

# 풀이
```python
import sys


def solution():
    n, c, adr = input()
    return parametric_search(adr, c, n)


def input():
    src = sys.stdin.buffer
    n, c = map(int, src.readline().split())
    adr = [int(x) for x in src.read().splitlines()]
    adr.sort()
    return n, c, adr


def parametric_search(adr, c, n):
    answer = 0
    lt = 1
    rt = adr[-1] - adr[0]
    while lt <= rt:
        cnt = 1
        mid = (lt + rt) >> 1
        before = adr[0]
        for i in range(1, n):
            if cnt == c:
                break
            if adr[i] - before >= mid:
                before = adr[i]
                cnt += 1
        if cnt == c:
            answer = mid
            lt = mid + 1
        else:
            rt = mid - 1
    return answer


print(solution())
```
- input : 입력
- parametric_search : 매개변수 탐색
  - 우리가 찾는건 가장 큰 '공유기간 최소 인접거리'이다. 첫번째 집에 공유기를 설치하고, 그 이후 모든 집을 순서대로 방문할 때마다 이전의 공유기
  설치지점으로부터의 거리가 '공유기간 최소 인접거리'보다 크거나 같으면 공유기의 갯수가 모자랄 때까지 설치를 계속한다.
  - 공유기가 남아돈다면 너무 '공유기간 최소 인접거리'가 길다는 것을 의미하고, rt를 mid보다 작게 하여 더 작은 범위에서 찾게 한다.
  - 공유기를 모두 사용하였다면, 조건을 만족한다. answer를 mid로 변경한 뒤 lt를 mid보다 크게 하여 더 큰 범위에서 찾게 한다.
    - 이 과정을 거치면 조건을 만족하는 한 mid는 계속적으로 증가하여 최적화된다. 

---
