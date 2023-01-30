# 문제
- 플랫폼 : 백준
- 번호 : 09095
- 제목 : 1, 2, 3 더하기
- 난이도 : Silver 3
- 정수를 1, 2, 3의 합으로 나타내는 방법의 수들을 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/9095" target="_blank">링크</a>

---

# 필요 알고리즘
- 다이나믹 프로그래밍(DP)

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write

counts = [0] * 11
counts[1] = 1
counts[2] = 2
counts[3] = 4
for i in range(4, 11):
    counts[i] = sum(counts[i-3:i])

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n'))

answer = '\n'.join(str(counts[n]) for n in numbers)
print(answer)
```
- n을 만드는 방법은 다음 세가지 케이스가 있다.
  - n-3을 만들고 3 더하기
  - n-2를 만들고 2 더하기
  - n-1을 만들고 1 더하기
- 1,2,3을 만드는 방법은 각각 1,2,4 가지이며, 4부터는 위 방식대로 순서대로 구해나가면 된다.

---
