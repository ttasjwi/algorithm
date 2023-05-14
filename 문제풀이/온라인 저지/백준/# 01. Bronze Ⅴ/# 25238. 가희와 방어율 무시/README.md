# 문제
- 플랫폼 : 백준
- 번호 : 25238
- 제목 : 가희와 방어율 무시
- 난이도 : Bronze 5
- A-B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25238" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
# a : 몬스터의 방어율, b : 유저의 방무
a, b = map(int, input().split())
end_shield_rate = a - a * (b / 100)
print(0 if end_shield_rate >= 100 else 1)
```
- a : 방어율
- b : 방무
- 실제 최종 방어율 : 방어율 - 방어율 * (방무/100)
  - 방무가 백분율(`%`) 로 주어지므로, 이를 다시 100으로 나눠서 실수화 시킨 뒤, 해당 값만큼을 차감해야한다.

---
