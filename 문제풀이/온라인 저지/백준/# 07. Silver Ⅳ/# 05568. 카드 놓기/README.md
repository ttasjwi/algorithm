# 문제
- 플랫폼 : 백준
- 번호 : 05568
- 제목 : 카드 놓기
- 난이도 : Silver 4
- 상근이가 만들 수 있는 정수의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5568" target="_blank">링크</a>

---

# 필요 알고리즘
- 순열

---

# 풀이
```python
import sys
from itertools import permutations

src = sys.stdin
src.readline()
k = int(src.readline())
print(len(set(''.join(c) for c in permutations(src.read().splitlines(), k))))
```
- 각 라인 값들을 여러 순서로 조합하다보니, 각각의 순서에 따라 구분이 있다 => 순열
- permutations를 통해 순열을 구하고, 이들을 join한 것들의 set을 구하고 len을 통해 원소의 갯수를 구해 반환

---
