# 문제
- 플랫폼 : 백준
- 번호 : 02748
- 제목 : 피보나치 수 2
- 난이도 : Bronze 1
- n이 주어졌을 때, n번째 피보나치 수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2748" target="_blank">링크</a>

---

# 필요 알고리즘
- dp
- 재귀

---

# 풀이

## 풀이1 : DP
```python
dp = [0, 1]

def main():
    answer = pibo(int(input()))
    print(answer, end='')


def pibo(n):
    if len(dp) >= n+1:
        return dp[n]
    result = pibo(n-1) + pibo(n-2)
    dp.append(result)
    return result


if __name__ == '__main__':
    main()
```
- 피보나치 수의 정의에 따라 풀려면, 재귀함수를 사용해야한다.
- 하지만 재귀함수를 통해 연산을 하다보면 중복된 연산을 하기 마련인데 이를 위해 이미 처리한 연산 결과를 캐시해두면 다시 연산하는 비용을 줄일 수
있다.

## 풀이2 : 단순 반복문
```python
n = int(input())

before, current = 0, 1
for i in range(2, n + 1):
    before, current = current, before + current

print(current, end='')
```
- 0번째, 1번째부터 순서대로 10번째 수까지 만들어가는 방식이다.

---
