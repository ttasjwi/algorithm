# 문제
- 플랫폼 : 백준
- 번호 : 32978
- 제목 : 아 맞다 마늘
- 난이도 : 32978
- 문제 : <a href="https://www.acmicpc.net/problem/32978" target="_blank">링크</a>

---

# 필요 지식
- 해시 테이블

---

# 풀이
```python
import sys

input = sys.stdin.readline

input()
print(({*input().split()} - {*input().split()}).pop())
```
- set 2개 만들어서 차집합 후, 남은 단 하나의 원소 출력

---
