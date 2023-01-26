# 문제
- 플랫폼 : 백준
- 번호 : 11021
- 제목 : A+B - 7
- 난이도 : Bronze 5
- 각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11021" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
print = sys.stdout.write

answer = '\n'.join(f'Case #{idx +1}: {sum(map(int, line.split()))}' for idx, line in enumerate(lines))
print(answer)
```

---
