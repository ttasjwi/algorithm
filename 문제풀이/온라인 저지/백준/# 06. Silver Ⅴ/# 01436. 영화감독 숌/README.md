# 문제
- 플랫폼 : 백준
- 번호 : 01436
- 제목 : 영화감독 숌
- 난이도 : Silver 5
- 6이 적어도 3개이상 연속으로 들어가는 수를 종말의 숫자라고 할 때, N번째 종말의 숫자 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1436" target="_blank">링크</a>

---

# 필요 알고리즘
- 브루트포스

---

# 풀이

## 풀이1
```python
n = int(input())

count = 0
number = 1
while True:
    if '666' in str(number):
        count += 1
        if count == n:
            break
    number += 1
print(number)
```
- 정말 순수하게 계속 숫자를 1씩 증가시켜가면서 판단
- 10000까지 갔을 때 2666799 이니까, 최악의 경우 2666799번 반복해야한다.

## 풀이2
```python
def main():
    n = int(input())
    print(find_number(n), end='')


def find_number(n):
    if n == 1:
        return 666

    count = 1
    prev_digit = 0  # 선두에 오는 자릿수(천의자리 이후의 수)
    num = None  # 선두에 오는 자릿수를 제외한 나머지 수(1~1000)

    while True:
        # 앞 자릿수가 X...666 일 경우(예 : 666_000, 1_666_004)
        if prev_digit % 1000 == 666:
            num = 0
            for i in range(1000):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 앞 자릿수가 X...66 일 경우 (예 : 66_000, 166_600)
        elif prev_digit % 100 == 66:
            num = 600
            for i in range(100):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 앞 자릿수가 X...6 일 경우 (예 : 6_660, 16_663)
        elif prev_digit % 10 == 6:
            num = 660
            for i in range(10):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 그 외 (예: 241_666, 23_666, 2_111_666, ...)
        else:
            num = 666
            if count == n:
                return prev_digit * 1000 + num
            count += 1
            prev_digit += 1


if __name__ == '__main__':
    main()
```
- 666, 1666, 2666, ... 이렇게 순서대로 증가시키는 방식
- 뒤의 세자리(num)와, 천의자리 이후의 숫자(prve_digit)를 분리해서 생각한다.
  - 앞 자릿수가 X...666 일 경우(예 : 666_000, 1_666_004)
  - 앞 자릿수가 X...66 일 경우 (예 : 66_000, 166_600)
  - 앞 자릿수가 X...6 일 경우 (예 : 6_660, 16_663)
  - 그 외 (예: 241_666, 23_666, 2_111_666, ...)
- 10000까지 돌 때 10000번 돌 수 있다.

---
