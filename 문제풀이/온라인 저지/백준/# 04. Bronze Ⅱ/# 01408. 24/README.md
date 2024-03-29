# 문제
- 플랫폼 : 백준
- 번호 : 01408
- 제목 : 24
- 난이도 : Bronze 2
- 도현이가 임무를 수행하는데 남은 시간을 문제에서 주어지는 시간의 형태 (XX:XX:XX)에 맞춰 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1408" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
h1, m1, s1 = map(int, input().split(sep=':'))
h2, m2, s2 = map(int, input().split(sep=':'))

# 시간의 차
diff = (h2 - h1) * 60 * 60 + (m2 - m1) * 60 + (s2 - s1)

h, m, s = 0, 0, 0

# 차가 음수일 경우, 24시를 더해야함(다음날 완료되기 때문)
if diff < 0:
    diff += 24 * 60 * 60

h = diff // (60 * 60) # 시 분리
diff = diff % (60 * 60)
m = diff // 60 # 분 분리
s = diff % 60 # 초 분리
print(f'{h:02d}:{m:02d}:{s:02d}')
```
- 첫 입력은 현재 시각, 두번쨰 시간은 임무 시작 시각(종료 시각)이다.
- 우선, 종료시각의 초 합에서 현재 시각의 초합을 뺀다.
  - 이 값이 0보다 작은 경우는 아직 24시를 경과하지 않은 상황이라는 것이고, 24 * 60 * 60초를 더한다.
- 이렇게 합산한 초 합을 다시 시분초로 환산하여 출력한다.

---
