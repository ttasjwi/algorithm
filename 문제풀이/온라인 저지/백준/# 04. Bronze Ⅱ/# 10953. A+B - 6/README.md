# 문제
- 플랫폼 : 백준
- 번호 : 10953
- 제목 : A+B - 6
- 난이도 : Bronze 2
- 각 테스트 케이스마다 A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10953" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```python
import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
print = sys.stdout.write

answer = '\n'.join(str(sum(map(int, line.decode().split(sep=',')))) for line in lines)
print(answer)
```

---
