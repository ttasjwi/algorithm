# BOJ 10818 : 최소, 최대
- 난이도 : Bronze 3
- 최솟값, 최댓값
- 문제 : [링크](https://www.acmicpc.net/problem/10818)

---  

## 풀이
```python
from sys import stdin


def main():
    _, *nums = map(int, stdin.buffer.read().split())
    min_num, max_num = solution(nums)
    print(min_num, max_num, sep=' ', end='')


def solution(nums):
    return min(nums), max(nums)


main()

```
- 많은 데이터를 입력받을 때, `stdin.buffer.read().split()`을 사용하면 공백, 개행문자를 기준으로 값을 끊어주는 것 같다.
- min, max 함수로 최소, 최대를 찾는다.
