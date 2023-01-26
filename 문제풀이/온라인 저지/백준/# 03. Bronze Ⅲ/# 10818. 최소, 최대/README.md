# 문제
- 플랫폼 : 백준
- 번호 : 10818
- 제목 : 최소, 최대
- 난이도 : Bronze 3
- N개의 정수들 중 최솟값, 최댓값 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/10818" target="_blank">링크</a>

---

# 필요 알고리즘
- 최소, 최대 구하기

---

# 풀이

## 풀이1
```python
import io, os

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())

min_value, max_value = min(numbers), max(numbers)
answer = ' '.join([str(min_value), str(max_value)])
print(answer, end='')
```
- min, max 함수를 통해 최소, 최대를 구해온다.
- 해당 함수들은 C언어로 구현된 것으로 추정되며, 아래에서 후술할 직접 구하는 방식보다 더 빠르다

## 풀이2
```python
import io, os

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())

min_value = 1_000_000
max_value = -1_000_000
for value in numbers:
    if value < min_value:
        min_value = value
    if value > max_value:
        max_value = value

answer = ' '.join([str(min_value), str(max_value)])
print(answer)
```
- 직접 최소, 최대를 갱신시킴

---
