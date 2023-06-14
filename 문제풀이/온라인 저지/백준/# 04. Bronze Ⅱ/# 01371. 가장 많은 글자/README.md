# 문제
- 플랫폼 : 백준
- 번호 : 01371
- 제목 : 가장 많은 글자
- 난이도 : Bronze 2
- 첫째 줄에 가장 많이 나온 문자를 출력한다. 여러 개일 경우에는 알파벳 순으로 앞서는 것부터 모두 공백없이 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1371" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
import sys

counter = [0 for ch in range(26)]

max_count = 0

for ch in sys.stdin.read():
    idx = ord(ch) - 97
    if idx >= 0:
        counter[idx] += 1
        if max_count < counter[idx]:
            max_count = counter[idx]

for i in range(26):
    if counter[i] == max_count:
        sys.stdout.write(chr(i+97))
```
- counter : 알파벳 카운터
- 문자를 하나하나 읽어가면서 알파벳이면 카운팅한다. 최대 카운트를 계속 따져가면서 갱신한다.
- 최대 카운트와 같은 카운트의 알파벳들을 순서대로 출력한다.

---

