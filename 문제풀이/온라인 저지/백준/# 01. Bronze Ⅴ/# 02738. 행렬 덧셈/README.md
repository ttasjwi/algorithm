# 문제
- 플랫폼 : 백준
- 번호 : 02738
- 제목 : 행렬 덧셈
- 난이도 : Bronze 5
- N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2738" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io
import os
import sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

n, m = map(int, input().split())

matrix_a = [input().split() for _ in range(n)]
matrix_b = [input().split() for _ in range(n)]

answer = '\n'.join([' '.join([str(int(a) + int(b)) for a, b in zip(x, y)]) for x, y in zip(matrix_a, matrix_b)])
print(answer)
```
- 입출력 : 100줄에 최대 각 라인별 100개 입력되므로, 입출력 스트레스가 심함. 따라서 빠른 입출력을 위한 라이브러리를 사용함
- 2차원 배열 2개를 zip해서, 각 행별로 또 다시 zip함

---
