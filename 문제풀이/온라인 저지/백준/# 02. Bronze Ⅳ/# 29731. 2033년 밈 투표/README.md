# 문제
- 플랫폼 : 백준
- 번호 : 29731
- 제목 : 2033년 밈 투표
- 난이도 : Bronze 4
- 문제 : <a href="https://www.acmicpc.net/problem/29731" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
import sys

input = sys.stdin.readline
memes = {
    "Never gonna give you up",
    "Never gonna let you down",
    "Never gonna run around and desert you",
    "Never gonna make you cry",
    "Never gonna say goodbye",
    "Never gonna tell a lie and hurt you",
    "Never gonna stop"
}

flag = False
for i in range(int(input())):
    line = input().rstrip()
    if line not in memes:
        flag = True
        break
print('Yes' if flag else 'No')
```
- 모든 밈들을 memes set에 추가.
- 매 라인마다 입력받아서, memes에 속하는 지 확인

---
