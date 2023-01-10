# BOJ 02741 : N 찍기
- 난이도 : Bronze 5
- 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하기
- 문제 : [링크](https://www.acmicpc.net/problem/2741)

---  

## 풀이
```python
import sys


def main():
    numbers = range(1, input_int() + 1)
    print('\n'.join(map(str, numbers)), end='')


def input_int():
    return int(sys.stdin.readline().rstrip())


main()

```
- 1부터 n까지 입력받아 출력

---
