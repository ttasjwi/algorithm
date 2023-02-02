# 문제
- 플랫폼 : 백준
- 번호 : 10816
- 제목 : 숫자 카드 2
- 난이도 : Silver 4
- 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10816" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시

---

# 풀이

## 풀이1
```python
import io, os, sys
from collections import Counter

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

input()
c = Counter(input().decode().split())
input()
answer = ' '.join(str(c[key]) for key in input().decode().split())
print(answer)
```
- 카운터로 카운팅
- 이후 들어온 라인의 각 요소를 카운터에서 찾아 그 숫자를 순서대로 출력

## 풀이2
```python
import io, os, sys
from collections import Counter
from operator import itemgetter

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

input()
c = Counter(input().decode().split())
input()
answer = ' '.join(map(str, itemgetter(*input().decode().split())(c)))
print(answer)
```
- itemgetter 생성시, 인자로 찾는 대상들을 순서대로 지정해 입력
- 해당 itemgetter를 f라 할 때, f(...)은 위에서 지정한 인자들을 순서대로 ...에서 찾아 튜플의 형태로 반환한다.

---

