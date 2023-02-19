# 문제
- 플랫폼 : 백준
- 번호 : 02056
- 제목 : 작업
- 난이도 : Gold 4
- 모든 작업을 완료하기 위한 최소 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2056" target="_blank">링크</a>

---

# 필요 지식
- 위상 정렬
- 다이나믹 프로그래밍(DP)

---

# 풀이
## 풀이1
```python
import sys

# 입력
src = sys.stdin.buffer

n = int(src.readline())
lines = [[*map(int, line.split())] for line in src.read().splitlines()]

# 초기화
nexts = [[] for _ in range(n + 1)] # 다음에 올 작업들
in_degrees = [0] * (n + 1) # 진입차수
times = [0] * (n + 1) # 각 작업별 소요 비용
total_times = [0] * (n + 1) # 해당 작업을 끝낸 시점의 '시각'
q = [] # 큐

for i in range(n):
    times[i + 1] = lines[i][0]
    in_degrees[i + 1] = lines[i][1]
    if not lines[i][1]: # 진입차수가 0이면, 계산을 완료한 것으로 간주하여 total_times를 갱신시키고 큐에 삽입한다.
        total_times[i + 1] = times[i + 1]
        q.append(i + 1)
    for pre in lines[i][2:]:
        nexts[pre].append(i + 1)

# 진입차수가 0이 된 것들을 순서대로 꺼내서 total_times를 갱신한다.
while q:
    work = q.pop(0)
    for next in nexts[work]:
        in_degrees[next] -= 1
        total_times[next] = max(total_times[next], total_times[work] + times[next])
        if in_degrees[next] == 0:
            q.append(next)

# total_times 중 가장 큰 값이 가장 마지막에 작업이 완료된 시각이다.
print(max(total_times))
```
- 각 라인을 읽어가면서
  - 진입 차수를 배열(in_degrees)에 기록
  - 각각의 선행 작업들의 다음 작업 목록(nexts)에 추가
  - 진입차수가 0인 것들은 큐에 삽입한다.
- 큐에서 꺼낸 작업들의 다음 작업들의 진입차수를 1 차감하고, 다음 작업의 예상 완료시각(total_times)이 기존 예상 완료 시각보다 클 경우 갱신한다.
  - (예를 들어, a-c, b-c과 같이 c를 하기 위해 a과 b를 수행해야할 경우 a,b 중 나중에 끝난 시간 대에 3의 시간을 더해야 3의 예상 완료 시각이 된다.)
- 다음 작업의 진입차수가 0이 되면, 큐에 삽입한다.
- 이 방식을 거치면 total_times 의 값들 중 가장 큰 값이 가장 마지막에 작업이 완료된 시각이다.

## 풀이2
```python
import sys

input = sys.stdin.buffer.readline

n = int(input())
dp = [0] * (n + 1)

for i in range(n):
    line = list(map(int, input().split()))
    if line[1]:
        dp[i + 1] = max(dp[x] for x in line[2:]) + line[0]
    else:
        dp[i + 1] = line[0]

print(max(dp))
```
- 이 문제에서는 한 가지 놓치기 쉬운 조건이 있다.
  - `아주 예쁘게 매겨져 있어서, K번 작업에 대해 선행 관계에 있는(즉, K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는)
  작업들의 번호는 모두 1 이상 (K-1) 이하이다.`
  - 어떤 작업의 선행 작업은 반드시 그 이전 번호인 것이다.
  - 입력이 들어오는 순서대로 그 작업의 완료시각을 확정하여 계산할 수 있고, 이를 이용하여 이후 들어오는 입력 작업의
  작업완료 시각 계산에 사용할 수 있다.
- 입력을 순서대로 읽어가면서, dp에 자기 자신의 완료시각을 기록한다.
  - 진입 차수가 0이면 소요 시간 그 자체가 완료 시각이다.
  - 진입 차수가 0이 아니면, 선행 작업들의 dp 배열 저장값 중 가장 큰 값에 자기 자신의 완료시각을 추가하면 된다.
- 이렇게 구해진 dp 값들 중 최댓값이 가장 마지막에 작어된 작업의 완료 시각이다.

---
