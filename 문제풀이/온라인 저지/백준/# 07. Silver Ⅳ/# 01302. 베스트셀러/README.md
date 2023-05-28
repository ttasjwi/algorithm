# 문제
- 플랫폼 : 백준
- 번호 : 01302
- 제목 : 베스트셀러
- 난이도 : Silver 4
- 가장 많이 팔린 책의 제목을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1302" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
import sys
from collections import Counter

src = sys.stdin
_ = src.readline()
c = Counter(src.read().splitlines())
print(min(c.keys(), key=lambda k: (-c[k], k)))
```
- Counter로 요소의 갯수를 센다.
- key들을 목록으로 얻어오고 이들(k)중 다음 기준에 따른 최솟값을 구한다.
  - `-c[k]` 값이 가장 작은 값 : 이 값이 가장 작다는 것은 카운트가 제일 큰 값이라는 뜻이다.
  - 위의 값이 같을 경우 k 순으로 얻어오기(오름차순)

---
