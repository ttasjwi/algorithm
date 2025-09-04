# 문제
- 플랫폼 : 백준
- 번호 : 02804
- 제목 : 크로스워드 만들기
- 난이도 : Bronze 1
- 문제 : <a href="https://www.acmicpc.net/problem/2804" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write
def find_cross_row_col(word_a, word_b):
    char_b_set = set(word_b)
    for c, char_a in enumerate(word_a):
        if char_a in char_b_set:
            cross_col = c
            for r, char_b in enumerate(word_b):
                if char_b == char_a:
                    cross_row = r
                    return cross_row, cross_col


word_a, word_b = input().split()
matrix = [['.' for _ in range(len(word_a))] for _ in range(len(word_b))]
cross_row, cross_col = find_cross_row_col(word_a, word_b)

for i, char_a in enumerate(word_a):
    matrix[cross_row][i] = char_a
for i, char_b in enumerate(word_b):
    matrix[i][cross_col] = char_b
answer = '\n'.join(map(lambda l: ''.join(l), matrix))
print(answer)
```
- `find_cross_row_col`: 교차되는 지점의 행, 열을 찾는다.
- 그 후, 교차되는 지점 행/열을 고려하여 단어를 다시 배치시킨다.
- 결과를 출력한다.

---
