# 문제
- 플랫폼 : 백준
- 번호 : 31775
- 제목 : 글로벌 포닉스
- 난이도 : Bronze 4
- 문제 : <a href="https://www.acmicpc.net/problem/31775" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
import sys

s = set(map(lambda x: x[0], sys.stdin.readlines()))
print('GLOBAL' if {'k', 'l', 'p'} == s else 'PONIX')
```
- 문자열을 전부 읽어오고, 첫글자 추출 -> set 화
- set 의 원소가 `k,l,p` 이면 'GLOBAL', 아니면 'PONIX'

