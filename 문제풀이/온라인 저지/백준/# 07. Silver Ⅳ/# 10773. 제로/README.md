# 문제
- 플랫폼 : 백준
- 번호 : 10773
- 제목 : 제로
- 난이도 : Silver 4
- 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다. 이런 방식으로 최종적으로 모안 수들의 합 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/10773" target="_blank">링크</a>

---

# 필요 알고리즘
- 스택

---

# 풀이
```python
import sys


def main():
    input = sys.stdin.readline

    stack = []
    for _ in range(int(input())):
        current = int(input())
        if current == 0:
            stack.pop()
        else:
            stack.append(current)
    print(sum(stack), end='')


if __name__ == '__main__':
    main()
```
- 스택을 사용하면 간단한 문제

---
