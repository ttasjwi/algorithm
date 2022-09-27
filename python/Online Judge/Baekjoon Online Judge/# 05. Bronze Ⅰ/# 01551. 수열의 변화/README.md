# BOJ 01151 : 수열의 변화

- 난이도 : Bronze 1
- 계차수열을 반복적으로 구하기
- 문제 : [링크](https://www.acmicpc.net/problem/1151)

---

## 풀이
```python
def main():
    _, k = map(int, input().split())
    numbers = list(map(int, input().split(sep=',')))
    change_k(numbers, k)
    print(*numbers, sep=',', end='')


def change(numbers):
    for i in range(0, len(numbers) - 1):
        numbers[i] = numbers[i + 1] - numbers[i]
    numbers.pop()


def change_k(numbers, k):
    for _ in range(k):
        change(numbers)


main()

```
- 구분자 끊는 것의 면에서는 파이썬이 정말 편하다.
- 앞에서부터 계차값으로 배열을 갱신시켜 나가고, 마지막 인덱스는 제거하는 행위를 k번 반복하면 된다.

---
