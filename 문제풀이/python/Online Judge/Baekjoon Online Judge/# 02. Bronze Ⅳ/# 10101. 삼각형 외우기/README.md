# BOJ 10101 : 삼각형 외우기
- 난이도 : Bronze 4
- 직사각형 내부 점에서 수선의 길이 최솟값
- 문제 : [링크](https://www.acmicpc.net/problem/1085)

---  

## 풀이
```python
import sys

input_int = lambda: int(sys.stdin.readline().rstrip())


def main():
    a = input_int()
    b = input_int()
    c = input_int()
    answer = solution(a, b, c)
    print(answer, end='')


def solution(a, b, c):
    if a + b + c != 180:
        return 'Error'
    if a == b == c:  # 정삼각형
        return 'Equilateral'
    if a == b or b == c or c == a:  # 이등변 삼각형
        return 'Isosceles'
    return 'Scalene'


main()

```
문제에서 주어진 조건대로 분기 처리하면 됨

---
