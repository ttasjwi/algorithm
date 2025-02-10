# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012914
- 제목 : 멀리 뛰기
- 난이도 : Level 2
- 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법의 수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12914" target="_blank">링크</a>

---

# 필요 지식
- DP
- 분할정복

---

# 풀이
이 문제는 구조적으로 피보나치 수열스럽게 동작한다.

### 풀이1: 탑다운 방식 DP(재귀함수 + 메모이제이션)
```python
import sys

def solution(n):
    sys.setrecursionlimit(2000)

    cache = [0] * (n+1)
    cache[0] = 1
    cache[1] = 1
    return dp(n, cache)

def dp(x, cache):
    if not cache[x]:
        cache[x] = (dp(x-2, cache) + dp(x-1, cache)) % 1234567
    return cache[x]
```
- 재귀함수를 호출
- 도중에 결과를 배열에 캐싱한다.


### 풀이2: 바텀업 방식 DP 
```python
def solution(n):
    a, b = 1, 1
    for _ in range(n):
        a, b = b, (a+b)%1234567
    return a
```

### 풀이3: 분할정복 + DP
```python
def solution(n):
    cache = {}
    base = [[1, 1], [1, 0]]
    return matrix_power(base, n, cache)[0][0]

def matrix_power(matrix, n, cache):
    if n == 1:
        return matrix
    if n in cache:
        return cache[n]
    half = matrix_power(matrix, n//2, cache)
    cache[n] = multiply_matrix(multiply_matrix(half, half), matrix) if n % 2 else multiply_matrix(half, half)
    return cache[n]

def multiply_matrix(a,b):
    result = [[0] * len(b[0]) for _ in range(len(a))]
    for i in range(len(a)):
        for j in range(len(b[0])):
            for k in range(len(b)):
                result[i][j] += (a[i][k] * b[k][j])
                result[i][j] %= 1234567
    return result
```
- 행렬의 거듭제곱을 이용하는 방식이다.

```shell
| a(n)    a(n-1) | = | 1 1 | ^ (n)   
| a(n-1)  a(n-2) |   | 1 0 |
```
- 피보나치 수열 규칙성에 따라 이 문제에서 구하는 규칙은 `an = (1,1)(1,0) ^ n [0][0]` 이다.
- 행렬의 거듭제곱은 분할정복으로 계산 가능하고 시간복잡도는 이 방식으로 풀 경우 O(log N) 이 된다.
- 여기에 중간중간 거듭제곱 결과물은 캐싱이 가능하다. 이를 활용하여 시간을 더 줄일 수 있다.

---
