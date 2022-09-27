# BOJ 02562 : 최댓값
- 난이도 : Bronze 3
- 최댓값, 최댓값의 인덱스
- 문제 : [링크](https://www.acmicpc.net/problem/2562)

---  

## 풀이1 : 반복문
```python
import sys

int_input = lambda: int(sys.stdin.readline().rstrip())

max_value = 0
max_pos = -1
for i in range(9):
    value = int_input()
    if value > max_value:
        max_value = value
        max_pos = i+1
print(max_value, max_pos, sep='\n', end='')


```
- 매 줄마다 숫자 입력받아 최댓값을 순차적으로 갱신

---

## 풀이2 : 함수
```python
import sys

int_input = lambda: int(sys.stdin.readline().rstrip())

numbers = [int_input() for _ in range(9)]
max_value = max(numbers)
max_pos = numbers.index(max_value) + 1
print(max_value, max_pos, sep='\n', end='')

```
- 리스트로 입력을 받은 뒤, 최댓값을 찾는다.
- index 함수로 최댓값의 인덱스를 찾아 1을 더한다

---
