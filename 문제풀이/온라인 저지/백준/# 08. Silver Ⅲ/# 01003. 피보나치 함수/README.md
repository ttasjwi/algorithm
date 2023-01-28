# 문제
- 플랫폼 : 백준
- 번호 : 01003
- 제목 : 피보나치 함수
- 난이도 : Silver 3
- 피보나치 함수를 호출했을 때 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1003" target="_blank">링크</a>

---

# 필요 알고리즘
- DP(다이나믹 프로그래밍)

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write
counts = [(1, 0), (0, 1)]


def main():
    nums = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:])
    answers = '\n'.join(solution(n) for n in nums)
    print(answers)


def solution(n):
    return ' '.join(map(str, calculate_count(n)))


def calculate_count(n):
    if len(counts) >= n + 1:
        return counts[n]
    a, b = calculate_count(n - 1), calculate_count(n - 2)
    count = (a[0] + b[0], a[1] + b[1])
    counts.append(count)
    return count


if __name__ == '__main__':
    main()
```
- fibonacci(n)을 호출했을 때 fibonacci(0), fibonacci(1)을 호출하는 횟수를 counts에 0부터 순서대로 기록한다.
  - counts(0) : (1, 0)
  - counts(1) : (0, 1)
- fibonacci(2)를 호출하면 fibonacci(0), fibonacci(1)을 호출하게 된다. 이때 count는 counts(0), counts(1)의 각 성분 합과 같다.
- fibonacci(3)를 호출하면 fibonacci(1), fibonacci(2)을 호출하게 된다. 이때 count는 counts(1), counts(2)의 각 성분 합과 같다.
- ...


---
