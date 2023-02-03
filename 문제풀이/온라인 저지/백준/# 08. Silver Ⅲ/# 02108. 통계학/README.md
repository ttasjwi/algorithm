# 문제
- 플랫폼 : 백준
- 번호 : 02108
- 제목 : 통계학
- 난이도 : Silver 3
- 주어진 숫자들의 산술평균, 중앙값, 최빈값, 범위 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2108" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학
- 구현
- 정렬

---

# 풀이

## 풀이1 : 배열 카운터
```python
import sys


def main():
    print = sys.stdout.write
    input = sys.stdin.readline

    n = int(input())
    counter = [0] * 8001

    max = -4001
    min = 4001
    sum = 0
    for _ in range(n):
        value = int(input())
        counter[value + 4000] += 1
        if value > max:
            max = value
        if value < min:
            min = value
        sum += value

    mode = -4001
    mode_count = 0
    mode_duplicated = False

    count = 0
    median = 4001
    for i in range(min + 4000, max + 4001):
        if counter[i]:
            count += counter[i]
            if median == 4001 and count >= n / 2:
                median = i - 4000
            if counter[i] > mode_count:
                mode = i - 4000
                mode_count = counter[i]
                mode_duplicated = False
            elif counter[i] == mode_count and not mode_duplicated:
                mode = i - 4000
                mode_duplicated = True

    avg = str(round(sum/n))
    median = str(median)
    mode = str(mode)
    scope = str(max-min)

    print('\n'.join([avg, median, mode, scope]))


if __name__ == '__main__':
    main()
```
- 입력 유효범위인 -4000부터 4000까지 등장하는 족족 배열에 카운팅한다.
  - 합 누적 -> 평균을 구할 수 있다.
  - 최대 최소 갱신 -> 범위를 구할 수 있다.
- 다시 최소범위부터 최대범위까지 배열을 순회하며 중앙값, 최빈값을 탐색한다.
  - 최빈값의 경우, 동일한 값이 두번째 나타낼 경우 해당값을 반환하도록 행야하므로 mode_duplicated 변수를 사용하여 재등장한 변수를 처리하도록
  하였다.
- 이렇게 모인 결과물들을 출력한다.

## 풀이2
```python
from collections import Counter
from sys import stdin, stdout


def main():
    print = stdout.write
    n = int(stdin.readline())
    c = Counter(range(-4000, 4001)) + Counter(map(int, stdin.read().split())) - Counter(range(-4000, 4001))
    elements = list(c.elements())
    mc = c.most_common(2)

    avg = str(round(sum(elements)/n))
    median = str(elements[n//2])
    mode = str(mc[0][0] if len(mc) == 1 or mc[0][1] > mc[1][1] else mc[1][0])
    scope = str(elements[-1] - elements[0])
    print('\n'.join([avg, median, mode, scope]))


if __name__ == '__main__':
    main()
```
- Counter를 활용한다.
- 속도 상으로 놓고보면 위의 풀이보다는 약간 미약하게 느리다.
- 다만, 공간비용이 많이 든다.

---
