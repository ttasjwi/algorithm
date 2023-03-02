# 문제
- 플랫폼 : 백준
- 번호 : 05575
- 제목 : 타임 카드
- 난이도 : Bronze 4
- 직원 A 씨, B 씨, C 씨의 출근 시간과 퇴근 시간이 주어 졌을 때 각 직원의 근무시간을 계산하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/5575" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.buffer.readline
print = sys.stdout.write


def solution(sh, sm, ss, eh, em, es):
    h, m, s = eh - sh, em - sm, es - ss
    if s < 0:
        m -= 1
        s += 60
    if m < 0:
        h -= 1
        m += 60
    print(f'{h} {m} {s}\n')


for _ in range(3):
    solution(*map(int, input().split()))
```
- 단순 시간의 뺄셈

---
