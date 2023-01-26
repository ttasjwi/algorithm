# 문제
- 플랫폼 : 백준
- 번호 : 02562
- 제목 : 최댓값
- 난이도 : Bronze 3
- 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2562" target="_blank">링크</a>

---

# 필요 알고리즘
- 최대/최소 구하기

---

# 풀이

## 풀이1
```python
import io, os, sys

print = sys.stdout.write

numbers = list(map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()))
max_value = max(numbers)
max_pos = numbers.index(max_value) + 1

answer = '\n'.join([str(max_value),str(max_pos)])
print(answer)
```
- 숫자들을 배열로 모아서, max 함수를 통해 최댓값을 찾는다.
- index 함수를 통해, 최댓값의 인덱스를 찾고 1 더한다.
- answer에 모아서 출력함

## 풀이2
```python
import io, os, sys

print = sys.stdout.write

numbers = list(map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()))

max_value = -1
max_pos = 0
for idx, value in enumerate(numbers):
    if value > max_value:
        max_value = value
        max_pos = idx + 1
answer = '\n'.join([str(max_value), str(max_pos)])
print(answer)
```
- enumerate를 통해 0번 인덱스의 요소부터 순서대로 접근
- value가 max_value보다 크면 최댓값을 갱신하고, 위치를 갱신
- 모아서 출력

---
