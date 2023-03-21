# 문제
- 플랫폼 : 백준
- 번호 : 26068
- 제목 : 치킨댄스를 추는 곰곰이를 본 임스 2
- 난이도 : Bronze 4
- 임스가 사용할 기프티콘의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/26068" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
import sys

cnt = 0
input = sys.stdin.readline
for _ in range(int(input())):
    x = int(input()[2:])
    if x <= 90:
        cnt += 1
print(cnt)
```
- 2번째 문자부터 뒤에 있는 숫자를 파싱하고 90보다 작거나 같으면 카운트를 증가시킨다.

---
