# 문제
- 플랫폼 : 백준
- 번호 : 11022
- 제목 : A+B - 8
- 난이도 : Bronze 5
- 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11022" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
    answer = '\n'.join(make_line(idx, line) for idx, line in enumerate(lines))
    print(answer)


def make_line(idx, line):
    a, b = map(int, line.split())
    return f'Case #{idx + 1}: {a} + {b} = {a + b}'


if __name__ == '__main__':
    main()
```

---
