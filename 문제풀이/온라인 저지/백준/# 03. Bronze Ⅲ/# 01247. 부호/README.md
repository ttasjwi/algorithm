# 문제
- 플랫폼 : 백준
- 번호 : 01247
- 제목 : 부호
- 난이도 : Bronze 3
- 3개의 줄에 걸쳐 각 테스트 셋에 대해 N개의 정수들의 합 S의 부호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1247" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io
import os
import sys

print = sys.stdout.write

numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines())
answer = [0] * 3

t_count = -1
count = 0
for n in numbers:
    if count == 0:
        count = n
        t_count += 1
    else:
        answer[t_count] += n
        count -= 1

answer = '\n'.join('+' if sum > 0 else '-' if sum < 0 else '0' for sum in answer)
print(answer)
```

---