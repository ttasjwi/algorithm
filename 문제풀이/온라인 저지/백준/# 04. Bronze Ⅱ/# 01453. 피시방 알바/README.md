# 문제
- 플랫폼 : 백준
- 번호 : 01453
- 제목 : 피시방 알바
- 난이도 : Bronze 2
- 거절당하는 사람의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1453" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
input()
customers = list(map(int, input().split()))
usable = [True] * 100

count = 0
for customer in customers:
    if usable[customer - 1]:
        usable[customer - 1] = False
    else:
        count += 1
print(count)
```
- 사용자 요청을 배열에 저장한다.
- 컴퓨터 사용 가능 여부 배열을 따로 준비한다.
- 사용자 요청 배열을 순서대로 순회하면서, 해당 자리로 사용자를 배치한다.
  - 이미 채워져있으면 요청을 거절하고 count를 증가한다.

---
