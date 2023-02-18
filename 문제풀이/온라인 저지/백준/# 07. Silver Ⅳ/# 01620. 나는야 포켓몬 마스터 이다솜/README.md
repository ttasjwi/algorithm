# 문제
- 플랫폼 : 백준
- 번호 : 01620
- 제목 : 나는야 포켓몬 마스터 이다솜
- 난이도 : Silver 4
- 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1620" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시

---

# 풀이
```python
import sys

lines = sys.stdin.buffer.read().decode().splitlines()

n, m = map(int, lines[0].split())
dic = {word: str(idx + 1) for idx, word in enumerate(lines[1:n + 1])}
answer = '\n'.join(lines[int(line)] if line.isdigit() else dic[line] for line in lines[1 + n:])
print(answer)
```
- 라인들을 입력받아서, 배열과 딕셔너리에 저장
- 입력이 숫자가 들어오면 배열의 인덱스에 위치한 포켓몬을, 문자열이 들어오면 딕셔너리에서 번호를 꺼낸다.

---
