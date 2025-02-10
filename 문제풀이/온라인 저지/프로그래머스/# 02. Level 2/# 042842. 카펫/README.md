# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042842
- 제목 : 카펫
- 난이도 : Level 2
- 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42842" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스
- 수학

---

# 풀이

### 풀이1: 완전탐색
```python
from math import sqrt

def solution(brown, yellow):
    sum = brown + yellow
    for y in range(3, int(sqrt(sum))+1):
        x, r = divmod(sum, y)
        if not r and (x-2) * (y-2) == yellow:
                return [x, y]
```
- 전체 면적(sum) = yellow + white
- s의 가로를 x, 세로를 y라 하자.(x, y는 정수 -> 따라서 sum 의 약수를 구해가면서 계산해야함)
  - 이 때 가로는 세로보다 크거나 같다.
- 또 (x-2) * (y-2) = yellow 가 성립한다.
- 3부터 sum 의 거듭제곱(이하)까지 y 값을 순회한다.
  - sum 을 구성하는 두 x, y 곱에서 y는 둘 중 작거나 같은 값이므로 3보다 크거나 같고, 거듭제곱근보다 작거나 같다)
  - sum 을 y 로 나눈 몫을 x, 나머지를 r 이라 하자.
  - r이 0이면서 `(x-2)*(y-2) == yellow` 인지 확인한다.
- 반복 끝에서 모든 조건을 만족하면 그 x, y 쌍이 정답이다.

### 풀이2: 수학(이차방정식)
```python
from math import sqrt

def solution(brown, yellow):
    # 가로(x) 기준으로 정리했을 때의 이차방정식 계수들
    a = 2
    b = - (brown + 4)
    c = 2 * (brown + yellow)

    # 판별식
    D = (b ** 2) - 4 * a * c

    # 근
    x = (- b + sqrt(D)) // (2 * a)
    y = (- b - sqrt(D)) // (2 * a)

    return [x, y]
```
- 가로를 x, 세로를 y라 해보자. 이 경우 다음 관계가 생긴다.
  - `yellow + brown = x * y`
  - `yellow = (x-2) * (y-2)`
- 이는 x, y 에 관한 연립 이차 방정식이 되는데 이를 x 기준으로 정리하면  
  `2*(x^2) - (brown + 4) * x + (2 * brown + 2 * yellow) = 0` 와 같다.
- 근의 공식을 적용하여 x, y 쌍을 구할 수 있고 x 는 y보다 크거나 같으므로, x, y 를 확정할 수 있다.
  주어진 문제에서는 정수쌍 x,y 가 반드시 존재하므로 복잡한 상황(허근 등)은 고려하지 않아도 된다.

---
