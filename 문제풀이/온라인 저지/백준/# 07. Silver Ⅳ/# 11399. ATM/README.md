# 문제
- 플랫폼 : 백준
- 번호 : 11399
- 제목 : ATM
- 난이도 : Silver 4
- 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11399" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬
- 그리디 알고리즘
---

# 풀이
```python
import sys

input = sys.stdin.buffer.readline

n = int(input())
times = sorted(map(int, input().split()))
sum = times[0]
for i in range(1, n):
    times[i] = times[i-1] + times[i]
    sum += times[i]
print(sum)
```
- 적은 시간이 드는 사람을 빨리 처리하게 하고, 시간이 오래 걸리는 사람을 나중에 처리하면 공동체 전체의 시간 비용 합계에서는 이득이다.
- 우선 시간들을 오름차순 정렬한다.
- 각각 배열의 인덱스에는 시간의 누적합을 저장하게 하고, 이들을 순서대로 더 한다.
- 최종합을 출력한다.

---


