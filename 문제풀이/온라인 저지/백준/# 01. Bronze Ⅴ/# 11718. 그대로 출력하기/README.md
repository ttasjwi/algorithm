# 문제
- 플랫폼 : 백준
- 번호 : 11718
- 제목 : 그대로 출력하기
- 난이도 : Bronze 5
- 입력 받은 대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11718" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).read
print = sys.stdout.write

answer = input().decode()
print(answer)
```
- 읽어온 바이트들을 통채로 디코딩
- 그대로 출력

---
