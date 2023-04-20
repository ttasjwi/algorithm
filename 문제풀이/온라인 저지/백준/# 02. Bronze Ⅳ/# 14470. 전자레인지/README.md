# 문제
- 플랫폼 : 백준
- 번호 : 14470
- 제목 : 전자레인지
- 난이도 : Bronze 4
- 고기를 B℃로 데우는 데 걸리는 시간을 초 단위로 한 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14470" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())

print(-a * c + d + b * e if a < 0 else (b - a) * e)
```
- a가 0보다 작을 때는 0도까지 올리는 시간, 0도에서 해동시키는 시간, b도까지 끌어올리는 시간을 모두 계산한다.
- a가 0보다 클 때는 a도에서 b도까지 끌어올리는 시간만 계산하면 된다.

---
