# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.07
- 제목 : 점수계산
- 여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 매 회마다 1씩 가산점을 추가 부여함. 총점을 구하여라.

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
input()

total = 0
combo = 0
for ch in input().split():
    if ch == '1':
        combo += 1
        total += combo
    else:
        combo = 0
print(total, end='')
```
- combo : 가산점
- total : 총점
- 정답이면 가산점 +1 후 추가, 틀리면 가산점을 0으로 초기화

---
