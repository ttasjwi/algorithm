# 문제
- 플랫폼 : 백준
- 번호 : 02439
- 제목 : 별 찍기 - 2
- 난이도 : Bronze 4
- 오른쪽을 기준으로 정렬한 별을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2439" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write

n = int(input())
answer = '\n'.join(' ' * (n - i) + '*' * i for i in range(1, n + 1))
print(answer)
```
- i번째 줄에서는 n-i개의 공백과, i개의 별이 순서대로 등장한다.

---
