# 문제
- 플랫폼 : 백준
- 번호 : 23795
- 제목 : 사장님 도박은 재미로 하셔야 합니다
- 난이도 : Bronze 4
- 윤성이가 도박판에서 버린 돈의 총 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/23795" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

print(sum(map(int, sys.stdin.buffer.read().splitlines()[:-1])))
```
- 모든 금액을 잃은 것이므로, 그냥 금액의 합을 구하면 된다.

---
