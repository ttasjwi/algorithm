# 문제
- 플랫폼 : 백준
- 번호 : 01267
- 제목 : 핸드폰 요금
- 난이도 : Bronze 3
- 싼 요금제의 이름과 요금을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1267" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write

input()
times = list(map(int, input().split()))

a, b = 0, 0
for time in times:
    a += (time // 30 + 1) * 10
    b += (time // 60 + 1) * 15
if a < b:
    print('Y ')
    print(str(a))
elif a == b:
    print('Y M ')
    print(str(a))
else:
    print('M ')
    print(str(b))
```