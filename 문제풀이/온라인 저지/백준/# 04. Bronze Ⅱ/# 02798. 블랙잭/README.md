# 문제
- 플랫폼 : 백준
- 번호 : 02798
- 제목 : 블랙잭
- 난이도 : Bronze 2
- N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2798" target="_blank">링크</a>

---

# 필요 알고리즘
- 브루트 포스

---

# 풀이
```python
def main():
    n, m = map(int, input().split())
    numbers = list(map(int, input().split()))

    answer = search(numbers, n, m)
    print(answer, end='')


def search(numbers, n, m):
    result = 0
    for i in range(0, n - 2):
        if numbers[i] >= m:
            continue
        for j in range(i + 1, n - 1):
            if numbers[i] + numbers[j] >= m:
                continue
            for k in range(j + 1, n):
                sum = numbers[i] + numbers[j] + numbers[k]
                if sum == m:
                    return sum
                if result < sum < m:
                    result = sum
    return result


if __name__ == '__main__':
    main()
```
- 매번 더하면서 m이상인지 확인하고 반복을 스킵할 수 있으면 스킵하도록 함
- 합이 sum 이면 바로 반환하고 매번 최대합을 갱신함

---
