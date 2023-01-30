# 문제
- 플랫폼 : 백준
- 번호 : 02579
- 제목 : 계단 오르기
- 난이도 : Silver 3
- 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2579" target="_blank">링크</a>

---

# 필요 알고리즘
- 다이나믹 프로그래밍(DP)

---

# 풀이
```python
import io, os, sys

src = io.BytesIO(os.read(0, os.fstat(0).st_size))

n, *numbers = map(int, src.read().decode().rstrip().split(sep='\n'))
print = sys.stdout.write

scores = [0] * (n+1)

for i in range(1, n+1):
    if i == 1:
        scores[1] = numbers[0]
    elif i == 2:
        scores[2] = numbers[0] + numbers[1]
    else:
        scores[i] = max(scores[i-3] + numbers[i-2], scores[i-2]) + numbers[i-1]

print(str(scores[n]))
```
- i번째 계단에 오기까지 얻을 수 있는 최대 점수를 scores[i]라 하자.
- i번 계단에 오기까지 얻을 수 있는 최대 점수는, i-3번 계단까지 최대 점수를 얻고, i-2번, i번 계단에 온 경우와, i-2번까지 최대 점수를 얻고
i-1번, i번 계단에 온 경우 두 경우 중 최댓값이다.

---
