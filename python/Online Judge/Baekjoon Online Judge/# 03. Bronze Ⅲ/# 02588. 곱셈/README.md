# BOJ 02588 : 곱셈
- 난이도 : Bronze 3
- 세로 곱셈
- 문제 : [링크](https://www.acmicpc.net/problem/2588)

---  

## 풀이
```python
a = int(input())
b = int(input())

b_each = list(map(int, str(b)))

result1 = a * b_each[-1]
result2 = a * b_each[-2]
result3 = a * b_each[-3]
result4 = a * b
print(result1, result2, result3, result4, sep='\n', end='')

```
- a를 숫자로 입력받는다
- b를 숫자로 입력받는다
- b의 각 자리 숫자를 분리하는 방법은 아래와 같다.
  - b를 문자열로 변환한다.
  - 이를 `map(int, ...)`로 변환하면 각자리 숫자가 분리된다.
  - 이를 리스트로 변환한다.

---
