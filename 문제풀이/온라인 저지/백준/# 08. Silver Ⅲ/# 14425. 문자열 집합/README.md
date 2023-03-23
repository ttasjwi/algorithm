# 문제
- 플랫폼 : 백준
- 번호 : 14425
- 제목 : 문자열 집합
- 난이도 : Silver 3
- M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14425" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 집합

---

# 풀이
```python
import sys

src = sys.stdin

n, m = map(int, src.readline().split())
s = set(src.readline().rstrip() for i in range(n))
print(len([1 for line in src.read().splitlines() if line in s]))
```
- n개 라인을 읽고 set에 저장(해시 사용)
- 다음 m개 라인의 각 요소를 set에서 존재 여부를 확인 후, 존재하는 것에 대해서만 카운팅

---
