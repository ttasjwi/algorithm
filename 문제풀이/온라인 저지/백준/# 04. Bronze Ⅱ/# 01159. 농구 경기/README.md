# 문제
- 플랫폼 : 백준
- 번호 : 01159
- 제목 : 농구 경기
- 난이도 : Bronze 2
- 선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1159" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

src = sys.stdin

src.readline()
dic = {chr(x): 0 for x in range(97, 123)}

for line in src.read().splitlines():
    dic[line[0]] += 1
answer = [k for k, v in dic.items() if v >= 5]
print('PREDAJA' if not answer else ''.join(answer))
```
- a부터 z까지 등장 카운트를 저장하는 딕셔너리를 생성
- 라인을 순서대로 읽어가며 첫 문자의 등장횟수를 기록
- 등장 횟수가 5 이상인 것들만 출력, 그러나 5 이상인 것이 없으면 'PREDAJA' 출력

---
