# BOJ 02083 : 럭비 클럽
- 난이도 : Bronze 4
- 이름, 나이, 몸무게 입력받고 이름, 연령그룹 출력
- 문제 : [링크](https://www.acmicpc.net/problem/2083)

---  

## 풀이
```python
import sys

input = lambda: sys.stdin.readline()

while True:
    name, age, weight = input().split()

    age, weight = int(age), int(weight)
    if name == '#' and age == weight == 0:
        break
    print(name, 'Senior' if age > 17 or weight >= 80 else 'Junior')

```
- 이름, 나이, 체중을 입력받는다.
- 종료 조건에 맞으면 반복 탈출
- 종료 조건에 맞지 않으면 Senior, Junior 결과 출력

---
