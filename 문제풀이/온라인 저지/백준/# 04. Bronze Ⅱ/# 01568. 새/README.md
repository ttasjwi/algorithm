# 문제
- 플랫폼 : 백준
- 번호 : 01568
- 제목 : 새
- 난이도 : Bronze 2
- 모든 새가 날아가기까지 총 몇 초가 걸리는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1568" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())

t = 0
bird = n
cur = 1

while bird > 0:
    if bird < cur:
        cur = 1
    bird -= cur
    cur += 1
    t += 1
print(t)
```
- t : 경과 시간
- bird : 나무에 앉아있는 새
- cur : 현재 불러야할 숫자
- 새가 나무 위에 1마리라도 있는 동안 다음을 반복한다
  - bird가 cur보다 작은 경우 cur를 다시 1로 초기화한다. (1부터 다시 시작)
  - bird에서 cur 마리만큼 차감하고
  - cur를 1 증가시킨다. (다음에 불러야 할 숫자)
  - 시간을 1초 경과 시킨다
- 최종적으로 경과 시간을 출력한다.

---
