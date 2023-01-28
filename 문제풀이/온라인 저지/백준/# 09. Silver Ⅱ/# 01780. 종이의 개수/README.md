# 문제
- 플랫폼 : 백준
- 번호 : 01780
- 제목 : 종이의 개수
- 난이도 : Silver 2
- 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1780" target="_blank">링크</a>

---

# 필요 알고리즘
- 분할정복 : 큰 문제를 작은 문제로 나눠서 풀기

---

# 풀이
```python
import io, os, sys

n = 0
matrix = None
counter = [0, 0, 0]


def main():
    input_args()
    search(0, 0, n)
    answer = '\n'.join(map(str, counter))
    sys.stdout.write(answer)


def input_args():
    global n, matrix
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split('\n')
    n, matrix = int(lines[0]), [list(map(int, line.split())) for line in lines[1:]]


def search(r, c, l):
    number = matrix[r][c]

    for i in range(r, r + l):
        for j in range(c, c + l):
            if matrix[i][j] != number:
                if l == 3:
                    for a in range(r, r + l):
                        for b in range(c, c + l):
                            counter[matrix[a][b] + 1] += 1
                    return
                sl = l//3
                for a in range(r, r + l, sl):
                    for b in range(c, c + l, sl):
                        search(a, b, sl)
                return

    counter[number + 1] += 1
    return


if __name__ == '__main__':
    main()
```
- 행렬을 전부 순서대로 순회하다가 다른 숫자가 나왔다면, 행렬을 9등분하여 다시 순회한다.
  - 재귀적으로 순회하면 된다.
- 그런데 이렇게 재귀적으로 순회하더라도 3*3 수준까지 재귀적으로 순회하는 것은 순회 비용이 커지므로
3*3 수준은 1*1로 쪼개 재귀함수를 호출하지 않고, 바로 직접 카운터를 증가시킨다.

---
