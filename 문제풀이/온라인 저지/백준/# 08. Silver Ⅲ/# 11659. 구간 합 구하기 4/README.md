# 문제
- 플랫폼 : 백준
- 번호 : 11659
- 제목 : 구간 합 구하기 4
- 난이도 : Silver 3
- M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11659" target="_blank">링크</a>

---

# 필요 알고리즘
- 누적합

---

# 풀이
```python
import sys
from itertools import accumulate

lines = map(bytes.split, sys.stdin.buffer.read().splitlines())
n, m = next(lines)
sums = list(accumulate(map(int, next(lines)), initial=0))
sys.stdout.write('\n'.join(str(sums[int(j)] - sums[int(i) - 1]) for i, j in lines))
```
- itertools.accumulate 함수를 사용하면 누적합에서 더 좋은 성능을 얻을 수 있다.
- 누적합 배열을 구하고, 끝점에서 시작점 이전의 누적합을 제거하면 구간의 합을 구할 수 있다.

---
