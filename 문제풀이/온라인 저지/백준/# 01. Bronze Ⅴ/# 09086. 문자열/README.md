# 문제
- 플랫폼 : 백준
- 번호 : 09086
- 제목 : 문자열
- 난이도 : Bronze 5
- 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9086" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```python
import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]
answer = '\n'.join(line[0]+line[-1] for line in lines)
sys.stdout.write(answer)
```

---
