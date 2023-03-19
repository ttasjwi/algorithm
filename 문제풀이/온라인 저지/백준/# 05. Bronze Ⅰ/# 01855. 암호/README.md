# 문제
- 플랫폼 : 백준
- 번호 : 01855
- 제목 : 암호
- 난이도 : Bronze 1
- 첫 줄에 원래의 문자열을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1855" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
k = int(input())
password = input()

# 라인 단위로 쪼개기
line_cnt = len(password) // k
lines = []
for i in range(line_cnt):
    line = password[k * i:k * (i+1)]
    if i % 2 == 0:
        lines.append(line)
    else:
        lines.append(line[::-1])

# 각 라인을 왼쪽 열부터 순서대로 결합
answer = ''.join(lines[c][r] for r in range(k) for c in range(line_cnt))
print(answer)
```
- 총 k개의 열이 있다면, 각 라인의 길이는 `len(password) // k`인데 이를 `line_cnt`로 한다.
- 주어진 암호를 라인 길이마다 끊어주면서, lines에 올바른 순서로 바꿔 저장한다.
- 이제 라인들이 모두 정상적으로 돌아왔으니 왼쪽열부터 순서대로 문자열을 결합한다.

---
