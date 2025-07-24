# 문제
- 플랫폼 : 백준
- 번호 : 06322
- 제목 : 직각 삼각형의 두 변
- 난이도 : Bronze 3
- 문제 : <a href="https://www.acmicpc.net/problem/6322" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 문자열 처리

---

# 풀이
```python
import sys
from math import sqrt

n = 0

while True:
    a, b, c = map(int, sys.stdin.readline().split())
    
    # 입력이 모두 0 인 경우 종료
    if a == b == c == 0:
        break
    n += 1
    
    # 각 미지값에 대한 제곱수 구하기
    if c == -1:
        x = 'c'
        vv = a ** 2 + b ** 2
    elif a == -1:
        x = 'a'
        vv = c ** 2 - b ** 2
    else:
        x = 'b'
        vv = c ** 2 - a ** 2

    print(f"Triangle #{n}")
    
    # 제곱수가 0보다 작거나 같으면, 에러. 아닌 경우 제곱근을 출력
    if vv <= 0:
        print("Impossible.\n")
    else:
        print(f"{x} = {sqrt(vv):.3f}\n")
```
