# 문제
- 플랫폼 : 백준
- 번호 : 02083
- 제목 : 럭비 클럽
- 난이도 : Bronze 4
- 나이가 17세보다 많거나, 몸무게가 80kg 이상이면 성인부, 그 외에는 청소년부일 때 클럽 회원 분류
- 문제 : <a href="https://www.acmicpc.net/problem/2083" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io
import os
import sys

print = sys.stdout.write


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[:-1]
    answer = '\n'.join([get_result(line.decode()) for line in lines])
    print(answer)


def get_result(line):
    name, age, weight = line.split()
    return f'{name} Senior' if int(age) > 17 or int(weight) >= 80 else f'{name} Junior'


if __name__ == '__main__':
    main()
```
- 라인 별로 조건에 맞게 문자열을 만들고, 모아서 출력

---
