# 문제
- 플랫폼 : 백준
- 번호 : 03009
- 제목 : 네 번째 점
- 난이도 : Bronze 3
- 직사각형의 네 번째 점의 좌표를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/3009" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
counter1 = {}
counter2 = {}

for _ in range(3):
    x, y = map(int, input().split())
    if x not in counter1:
        counter1[x] = 1
    else:
        counter1[x] += 1
    if y not in counter2:
        counter2[y] = 1
    else:
        counter2[y] += 1

answer_x = 0
answer_y = 0
for x, count in counter1.items():
    if count == 1:
        answer_x = x
        break
for y, count in counter2.items():
    if count == 1:
        answer_y = y
        break
print(answer_x, answer_y, sep=' ')
```
- 카운터를 등록해둔다.
- 카운트가 1인 x, y 좌표를 조합한 값이 네번째 점이다.
