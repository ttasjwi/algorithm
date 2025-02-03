# 문제
- 플랫폼 : 백준
- 번호 : 31821
- 제목 : 학식 사주기
- 난이도 : Bronze 4
- 결제 금액 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/31821" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
prices = list(map(int, [input() for _ in range(n)]))

result = 0
m = int(input())
for i in range(m):
    result += prices[int(input()) - 1]
print(str(result))
```
- 가격 목록을 배열에 저장해둔다.
- 배열에 저장된 가격 정보를 수집하고, 새내기들의 메뉴 선택에 따라 순서대로 가격 합을 구한다.

---
