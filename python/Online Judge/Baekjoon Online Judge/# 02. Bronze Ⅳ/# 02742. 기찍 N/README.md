# BOJ 02742 : 기찍 N
- 난이도 : Bronze 4
- 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하기
- 문제 : [링크](https://www.acmicpc.net/problem/2742)

---  

## 풀이
```python
import sys


def main():
    numbers = range(input_int(), 0, -1)
    print('\n'.join(map(str, numbers)), end='')


def input_int():
    return int(sys.stdin.readline().rstrip())


main()

```
- n부터 1까지 순서대로 출력
- 문자열 반복 결합은 join이 좀 더 빠른 것 같긴하다.
