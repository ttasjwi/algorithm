# 문제
- 플랫폼 : 백준
- 번호 : 02576
- 제목 : 홀수
- 난이도 : Bronze 3
- 홀수가 존재하지 않는 경우에는 첫째 줄에 -1을 출력한다. 홀수가 존재하는 경우 첫째 줄에 홀수들의 합을 출력하고,
둘째 줄에 홀수들 중 최솟값을 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/2576" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
min_odd = 101
total = 0
for _ in range(7):
    k = int(input())
    if k % 2:
        total += k
        if min_odd > k:
            min_odd = k
if min_odd == 101:
    print(-1)
    exit(0)
print(total)
print(min_odd)
```
- 입력받고, 홀수인지 여부를 먼저 판단한 뒤 합산, 최솟값 갱신
- 최종적으로 최솟값이 101이면 홀수가 없음을 의미하므로 -1 출력
- 그렇지 않을 경우 total, min_odd 출력

---
