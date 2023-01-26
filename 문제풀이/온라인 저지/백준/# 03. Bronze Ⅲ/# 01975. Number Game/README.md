# 문제
- 플랫폼 : 백준
- 번호 : 01975
- 제목 : Number Game
- 난이도 : Bronze 3
- N을 먼저 정하고, 이 숫자를 2진법, 3진법, 4진법, ..., 100만진법, 100만 1진법 등등으로 바꾸어 보면서, 마지막자리에 연속된 0의 개수를
모두 더한 것들을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1975" target="_blank">링크</a>

---

# 필요 알고리즘
- 메모이제이션

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write
cache = {}


def main():
    _, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())
    answer = '\n'.join(get_result(n) for n in numbers)
    print(answer)


def get_result(n):
    if n in cache:
        return cache[n]

    result = 0
    for i in range(2, n + 1):
        copy_n = n

        while copy_n % i == 0:
            result += 1
            copy_n //= i

    cache[n] = str(result)
    return cache[n]


if __name__ == '__main__':
    main()
```
- 문제에서는 같은 수가 입력되지 않는다는 제약이 있고, 입력 라인수가 10만을 넘어간다.
- 중복된 계산을 다시 하지 않도록 별도로 cache를 해두면 풀이 속도를 대폭 절감시킬 수 있다.

---
