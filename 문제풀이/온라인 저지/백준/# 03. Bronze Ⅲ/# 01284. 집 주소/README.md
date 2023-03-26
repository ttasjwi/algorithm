# 문제
- 플랫폼 : 백준
- 번호 : 01284
- 제목 : 집 주소
- 난이도 : Bronze 3
- 각 입력마다 얼마만큼 너비를 차지하는지 정수로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1284" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print('\n'.join(str(sum(4 if ch == '0' else 2 if ch == '1' else 3 for ch in line) + len(line) + 1) for line in sys.stdin.read().splitlines()[:-1]))
```
- 라인을 순서대로 읽어가면서, 각 문자의 너비값을 합하고, 문자열의 길이 + 1 만큼의 여백값을 더한다.

---
