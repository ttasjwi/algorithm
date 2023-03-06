# 문제
- 플랫폼 : 백준
- 번호 : 13706
- 제목 : 제곱근
- 난이도 : Silver 4
- 정수 N의 제곱근을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13706" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색

---

# 풀이
## 풀이1
```python
from math import sqrt

print(int(sqrt(int(input()))))
```
- `math.sqrt` 함수를 통해 실수 제곱근을 구하고, 이를 int로 변환한뒤 출력해보려고 했다.


## 풀이2
```python
n = int(input())


def find_sqrt():
    lt = 1
    rt = n
    while lt <= rt:
        mid = (lt + rt) // 2
        x = mid ** 2
        if x == n:
            return mid
        elif x < n:
            lt = mid + 1
        else:
            rt = mid - 1


print(find_sqrt())
```
- 이분 탐색을 통해 O(logN)으로 찾는다.

## 풀이3
```python
from math import isqrt

print(isqrt(int(input())))
```
- math.isqrt 함수를 사용하면 양의 정숫 제곱근을 얻을 수 있다.

---
