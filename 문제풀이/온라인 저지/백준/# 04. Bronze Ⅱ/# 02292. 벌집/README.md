# 문제
- 플랫폼 : 백준
- 번호 : 02292
- 제목 : 벌집
- 난이도 : Bronze 2
- 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산
- 문제 : <a href="https://www.acmicpc.net/problem/2292" target="_blank">링크</a>

---

# 필요 알고리즘
- 수열

---

# 풀이
```python
n = int(input())
level = 1
level_end = 1

while n > level_end:
    level_end += 6 * level
    level += 1

print(level, end='')
```
- 한 주기별 마지막 끝 방 번호는 1, 7, 19, 37, 61, ... 이다.
- 끝 방 번호는 매번 6의 배수씩 증가한다.
