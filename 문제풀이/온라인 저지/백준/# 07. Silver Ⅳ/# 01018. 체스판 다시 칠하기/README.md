# 문제
- 플랫폼 : 백준
- 번호 : 01018
- 제목 : 체스판 다시 칠하기
- 난이도 : Silver 4
- 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1018" target="_blank">링크</a>

---

# 필요 알고리즘
- 누적합

---

# 풀이

## 풀이1
```python
import io
import os

array = [[True if ch == 'W' else False for ch in line] for line in
         io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]]

answer = 33
for i in range(0, len(array) - 7):
    for j in range(0, len(array[0]) - 7):
        start = array[i][j]
        is_wrong = not start
        count = 0
        for a in range(0, 8):
            for b in range(0, 8):
                if array[i + a][j + b] == is_wrong:
                    count += 1
                is_wrong = not is_wrong
            is_wrong = not is_wrong
        answer = min(answer, min(count, 64 - count))
print(answer, end='')
```
- 4중 for문
- 8*8 이 시작되는 곳을 기준으로 시작하여 잘못된 위치를 카운팅하고, 64에서 뺀 만큼의 값과 비교하여 작은 쪽을 최솟값과 비교한다.
- 최솟값을 갱신시키고, 최솟값 반환

## 풀이2: 순회구조 개선(누적합)
```python
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
array = [[True if ch == 'W' else False for ch in input()] for _ in range(n)]
counter = [[0 for j in range(m + 1)] for _ in range(n + 1)]
answer = 32
for i in range(1, n + 1):
    flag = i % 2
    for j in range(1, m + 1):
        current = array[i - 1][j - 1]
        counter[i][j] = counter[i - 1][j] + counter[i][j - 1] - counter[i - 1][j - 1]
        if current != flag:
            counter[i][j] += 1
        flag = not flag

        if i >= 8 and j >= 8:
            area_sum = counter[i][j] - counter[i - 8][j] - counter[i][j - 8] + counter[i - 8][j - 8]
            if area_sum > 32:
                area_sum = 64 - area_sum
            if answer > area_sum:
                answer = area_sum
print(answer, end='')
```
- 4중 for문을 돌았는데, 이를 2중 for문으로 처리할 수 있다.
- (1,1)을 True로 기준 잡았을 때 올바르지 않은 갯수를 카운트하는데, 누적해서 카운트한다.
- 즉 counter에는 누적된 올바르지 않은 갯수를 모아둔다.
- 누적합을 토대로 자기 앞 8*8 영역의 올바르지 않은 갯수를 바로 얻어낼 수 있다.
- 이 값이 32보다 크면 64에서 빼주고, 최솟값과 비교하여 갱신한다.
- 최종적으로 최솟값을 출력한다.
- 똑같은 곳을 다시 순회해야하는 풀이1보다 빠르다.

---
