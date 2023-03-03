# 문제
- 플랫폼 : 백준
- 번호 : 05524
- 제목 : 입실 관리
- 난이도 : Bronze 4
- i번째 줄에, i번째 입실자의 이름을 소문자로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5524" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

src = sys.stdin
print = sys.stdout.write

src.readline()
print('\n'.join(line.lower() for line in src.read().splitlines()))
```
- 각 라인을 `lower()` 함수를 이용하여 소문자화 시키고 출력

---
