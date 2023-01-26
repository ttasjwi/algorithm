# 문제
- 플랫폼 : 백준
- 번호 : 01009
- 제목 : 분산처리
- 난이도 : Bronze 2
- a ** b 번째 데이터가 처리될 컴퓨터의 번호들을 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/1009" target="_blank">링크</a>

---

# 필요 알고리즘
- 나머지 연산

---

# 풀이
```python
import io, os

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
com_numbers = [[10], [1], [6, 2, 4, 8], [1, 3, 9, 7], [6, 4], [5], [6], [1, 7, 9, 3], [6, 8, 4, 2], [1, 9]]


def main():
    answer = '\n'.join(str(get_com_number(line)) for line in lines)
    print(answer, end='')


def get_com_number(line):
    a, b = map(int, line.split())
    a %= 10
    return com_numbers[a][b % len(com_numbers[a])]


if __name__ == '__main__':
    main()
```
- 정수의 거듭제곱 꼴은 끝자리가 주기성을 가짐을 활용한다.


---
