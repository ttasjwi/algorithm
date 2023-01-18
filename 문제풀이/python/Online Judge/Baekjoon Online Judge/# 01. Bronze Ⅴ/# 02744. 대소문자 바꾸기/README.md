# BOJ 02744 : 대소문자 바꾸기

- 난이도 : Bronze 5
- 대소문자 바꾸기
- 문제 : [링크](https://www.acmicpc.net/problem/2744)

---

## 삽질
```python
import sys

word = sys.stdin.readline().rstrip()

result = []
for char in word:
    if char.isupper():
        result.append(char.lower())
    else:
        result.append(char.upper())

print(*result, sep='', end='')
```
- 수동으로 대소문자 바꿈

---

## 다른 사람들 풀이
```python
word = input()
print(word.swapcase(), end='')

```
- 뭐죠 왜 이런 함수가 있는거야 파이썬은

---
