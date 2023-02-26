# 문제
- 플랫폼 : 백준
- 번호 : 05717
- 제목 : 상근이의 친구들
- 난이도 : Bronze 4
- 각 테스트 케이스마다 상근이의 친구의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5717" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print('\n'.join([str(sum(map(int, line.split()))) for line in sys.stdin.buffer.read().splitlines()[:-1]]))
```
- 끝 라인 빼고 각 라인 숫자 합한 결과만 모아 출력

---
