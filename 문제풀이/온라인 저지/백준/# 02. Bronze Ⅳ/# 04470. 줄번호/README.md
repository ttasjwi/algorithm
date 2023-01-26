# 문제
- 플랫폼 : 백준
- 번호 : 04470
- 제목 : 줄번호
- 난이도 : Bronze 4
- 각 문장의 앞에 줄 번호를 추가한 뒤 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4470" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
lines = ''.join([f'{idx + 1}. {line.decode()}' for idx, line in enumerate(lines)])
print(lines)
```
- 1번부터 마지막 라인까지 순서대로 번호를 붙여줌