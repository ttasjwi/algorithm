# 문제
- 플랫폼 : 백준
- 번호 : 01052
- 제목 : 물병
- 난이도 : Silver 1
- 상점에서 사야하는 물병의 최솟값
- 문제 : <a href="https://www.acmicpc.net/problem/1052" target="_blank">링크</a>

---

# 필요 알고리즘
- 그리디 알고리즘
- 비트 마스킹

---

# 풀이
```python
def main():
    n, k = map(int, input().split())
    init_n = n

    while count_bit(n) > k:
        n += n & (-n)
    print(n - init_n, end='')


def count_bit(n):
    count = 0
    while n > 0:
        if n % 2:
            count += 1
        n = n >> 1
    return count


if __name__ == '__main__':
    main()
```
- 13 -> 8 + 4 + 1 -> 1101(2)
  - 13개의 물병은 8L 물병 1개, 4L 물병 1개, 1L 물병 1개까지 압축할 수 있다.
  - 이 문제는 n을 이진법으로 변환하여 생각하면 편리해진다.
- 반복
  - n의 비트를 세서, k보다 많으면 값을 더하여 비트를 줄여나간다.
    - 이 문제에서는 나눗셈을 하면서 비트를 셌는데, `bin(n).count('1')`로 세도 된다.
  - `n & (-n)` 연산은 n의 가장 끝 비트만을 참으로 하는 숫자를 반환한다. (예: 1110 & 0010 -> 0010)
  - 이 과정을 거치면 비트를 왼쪽으로 한 단계 밀어내고, 더 밀어낼 위치가 없으면 자리를 올림시켜서, 최종적으로는 병의 갯수를 줄일 수 있게 된다.
    - 예) 1101 -> 끝비트 0001을 더하고 끝 자리올림 -> 1110 -> 끝비트 0010을 더 하고 끝 자리올림 -> 10000

---
