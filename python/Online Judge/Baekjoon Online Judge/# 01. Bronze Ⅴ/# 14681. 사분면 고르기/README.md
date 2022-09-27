# BOJ 14681 : 사분면 고르기

- 난이도 : Bronze 5
- x,y 입력 받아서 어느 사분면에 속하는지 출력
- 문제 : [링크](https://www.acmicpc.net/problem/14681)

---  

## 풀이

```python
def main():
    x = int(input())
    y = int(input())
    answer = solution(x, y)
    print(answer, end='')


def solution(x, y):
    if y > 0:
        if x > 0:
            return '1'
        return '2'
    else:
        if x < 0:
            return '3'
        return '4'


main()

```
- 숫자 입력받고 조건에 맞게 판단하여 출력

---
