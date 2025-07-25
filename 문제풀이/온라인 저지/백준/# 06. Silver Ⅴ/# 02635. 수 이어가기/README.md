# 문제
- 플랫폼 : 백준
- 번호 : 02635
- 제목 : 수 이어가기
- 난이도 : Silver 5
- 문제 : <a href="https://www.acmicpc.net/problem/2635" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
max_length = 0
max_length_nums = []
for y in range(1, n + 1):
    nums = [n]
    x = n
    while True:
        nums.append(y)
        z = x - y
        if z < 0:
            break
        x, y = y, z
    if len(nums) > max_length:
        max_length = len(nums)
        max_length_nums = nums

print(f'{max_length}\n{' '.join(map(str, max_length_nums))}')
```
- 문제에서 시키는대로 수행.
- 처음 입력된 값 이하의 숫자를 임의로 선택(반복)하고 시작하여 숫자들을 구한뒤 제일 숫자 갯수가 많으면 그걸 출력으로 택하면 되는 것이다.

---
