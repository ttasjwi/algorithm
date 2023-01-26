# 문제
- 플랫폼 : 백준
- 번호 : 01181
- 제목 : 단어 정렬
- 난이도 : Silver 5
- N개의 단어가 들어오면, 길이가 짧은 것부터, 길이가 같으면 사전 순으로 정렬
- 문제 : <a href="https://www.acmicpc.net/problem/1181" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬

---

# 풀이
```python
import io, os, sys

answer = '\n'.join(
    sorted(set(io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().strip().split('\n')[1:]),
           key=lambda x: (len(x), x)))
sys.stdout.write(answer)
```
- set으로 중복을 제거
- 정렬(길이 -> 사전순)

---
