# 문제
- 플랫폼 : 백준
- 번호 : 02775
- 제목 : 부녀회장이 될테야
- 난이도 : Bronze 1
- 각각의 Test case에 대해서 해당 집의 거주민 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2775" target="_blank">링크</a>

---

# 필요 알고리즘
- DP

---

# 풀이
```python
import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

numbers = [[0 for _ in range(15)] for _ in range(15)]
for r in range(15):
    for c in range(15):
        if r == 0 or c == 0:
            numbers[r][c] = c
        else:
            numbers[r][c] = numbers[r][c-1] + numbers[r-1][c]

t = int(input())

answers = []
while t > 0:
    k = int(input())
    n = int(input())
    answers.append(str(numbers[k][n]))
    t -= 1
answers = '\n'.join(answers)
print(answers)
```
- 잘 생각해보면 r층 c호에 사는 사람은 r층 c-1호 사람의 수에, r-1층 c호 사람수를 더한 사람만큼 산다.
- 1층부터 순서대로 계산해두고, 이후 질의할 때는 배열에 바로 접근하도록 하면 된다.

---

# 삽질
```python
numbers = [[0]* 15] * 15
```
- 이렇게 이차원 리스트를 초기화하지 말자.

---
