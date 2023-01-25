# 문제
- 플랫폼 : 백준
- 번호 : 25304
- 제목 : 영수증
- 난이도 : Bronze 5
- 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes, 일치하지 않는다면 No를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25304" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

x = int(input())
n = int(input())

total = 0
for i in range(n):
    price, count = map(int, input().split())
    total += price * count

answer = 'Yes' if x == total else 'No'
print(answer)
```

---
