# 문제
- 플랫폼 : 백준
- 번호 : 02010
- 제목 : 플러그
- 난이도 : Bronze 3
- 첫째 줄에 최대로 전원에 연결될 수 있는 컴퓨터의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2010" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

src = sys.stdin.buffer
n = int(src.readline())
print(sum([int(line) for line in src.read().splitlines()]) - (n - 1))
```
- 첫째 라인은 멀티탭의 갯수이다.
- 그 이후 라인은 각 멀티탭 플러그 갯수인데, 이들의 합을 구한다.
- 마지막 플러그를 제외한 나머지 플러그들은 1번째 자리를 다음 플러그를 연결하기 위한 자리를 마련해야한다.
n-1개의 플러그가 1개의 자리를 비워야하므로 n-1을 차감한다.

---
