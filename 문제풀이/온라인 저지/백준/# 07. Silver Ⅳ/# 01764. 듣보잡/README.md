# 문제
- 플랫폼 : 백준
- 번호 : 01764
- 제목 : 듣보잡
- 난이도 : Silver 4
- 듣보잡의 수와 그 명단을 사전순으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1764" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시
- 정렬

---

# 풀이
```python
import sys

lines = sys.stdin.buffer.read().decode().splitlines()

n, m = map(int, lines[0].split())
c = sorted(set(lines[1:n + 1]) & set(lines[n + 1:]))
print(len(c))
print('\n'.join(c))
```
- 파이썬 set의 교집합 연산으로 겹치는 것들을 구함
- 정렬된 리스트로 변환
- 길이 구하여 출력
- 요소들 순서대로 출력

---
